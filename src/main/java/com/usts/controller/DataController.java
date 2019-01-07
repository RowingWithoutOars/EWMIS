package com.usts.controller;

import com.usts.model.DataObject;
import com.usts.model.LBObject;
import com.usts.service.IDataService;
import com.usts.tools.MapConvertObject;
import com.usts.tools.SqlToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private IDataService iDataService;

    //根据id查找对应的一条数据
    @RequestMapping(value = "/listData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listData() {
        Map<String,Object> returnMap = new HashMap<>();
        DataObject dataObject = iDataService.selectData(1);
        returnMap = SqlToMap.convertMap(dataObject);
        return  returnMap;
    }

    // 根据单一的属性查找所有的数据
    @RequestMapping(value = "/listSingleData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listSingleData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        if (map!=null) {
            // 遍历Map中的属性值
            String sx = map.get("sxkey").toString();
            List<DataObject> dataObject = iDataService.selectDataBySingle(sx);
            returnMap = SqlToMap.convertMap(dataObject);
        }
        return  returnMap;

    }

    // 根据多个属性查找所有的数据
    @RequestMapping(value = "/listMOreData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listMoreData(@RequestBody Map map) {
        Map returnMap = new HashMap<>();
        DataObject dataObject = MapConvertObject.mapConvertDataObject(map);
        List<DataObject> dataObjects = iDataService.selectDataByObject(dataObject);
        returnMap = SqlToMap.convertMap(dataObjects);

        return  returnMap;

    }

    // 增加一条数据
    @RequestMapping(value = "/addData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map addData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();

        return  returnMap;
    }

    // 删除一条数据
    @RequestMapping(value = "/delData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map delData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();

        return  returnMap;
    }

    // 更新一条数据
    @RequestMapping(value = "/updataData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map updataData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();

        return  returnMap;
    }

    @RequestMapping(value = "/statisticData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map statisticData(){
        // 获取类别
        Map map = new HashMap();
        map.put("sxkey","浮游植物");
        HashMap<String,Integer> paraMap = new HashMap();
        for (Object key : map.keySet()) {
            paraMap.put(map.get(key).toString(),-1);
        }
        List<LBObject> res = new ArrayList();
        for (String p:paraMap.keySet()){
            res = this.iDataService.selectDatafuzzy("%"+p+"%");
            if (res.size()==1){
                paraMap.put(res.get(0).getSxkey(),res.get(0).getSxvalue());
            }else if(res.size() >= 1){
                for (LBObject lbObject:res){
                    paraMap.put(lbObject.getSxkey(),lbObject.getSxvalue());
                }
            }
            paraMap.remove(p);
        }
        Map returnMap = new HashMap();
        // 将所有统计属性放在同一个map
        for (String p: paraMap.keySet()){
            DataObject d = new DataObject();
            d.setLb(paraMap.get(p));
            List l = this.iDataService.selectDataByObject(d);
            returnMap.put(p,l);
        }
        return returnMap;
    }

}

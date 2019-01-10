package com.usts.controller;

import com.usts.dao.IUserDao;
import com.usts.model.DataObject;
import com.usts.model.Users;
import com.usts.service.IDataService;
import com.usts.service.IUserService;
import com.usts.tools.MapConvertObject;
import com.usts.tools.SqlToMap;
import com.usts.tools.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/data")
public class DataController {



    @Autowired
    private IDataService iDataService;

    @Autowired
    private IUserService iUserService;

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
        if(map.get("userid")!=null&&map.get("sxkey")!=null) {// 判断是否为正常值
            int userid = Integer.parseInt(map.get("userid").toString());
            System.out.println("=====================userid:"+userid);
            Users users = iUserService.selectUser(userid);
            System.out.println("===========sxkey:"+map.get("sxkey"));
            System.out.println("===========getAuth():"+users.getAuth());
            if (users.getAuth().contains(Integer.parseInt(map.get("sxkey").toString()))){
                if (map != null) {
                    // 遍历Map中的属性值
                    String sx = map.get("sxkey").toString();
                    List<DataObject> dataObject = iDataService.selectDataBySingle(sx);
                    returnMap = SqlToMap.convertMap(dataObject);
                }
            }
        }
        return returnMap;
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
        Map returnMap = new HashMap();
        ArrayList tlist = new ArrayList();
        tlist.add("2018.03");
        tlist.add("2018.06");
        returnMap.put("time",tlist);
        ArrayList sxvalue = new ArrayList();
        sxvalue.add("123");
        sxvalue.add("188");
        returnMap.put("sxvalue",sxvalue);
        returnMap.put("jcdw","TH1");
        returnMap.put("sx","硅藻门");
        List jcd = new ArrayList();
        String[] jc = {"TH1","TH2","TH3","TH4","TH5"};
        for (String s:jc){
            jcd.add(new Tuple(s));
        }
        returnMap.put("jcd",jcd);
        return returnMap;
    }

}

package com.usts.controller;

import com.usts.model.DataObject;
import com.usts.model.PicModel;
import com.usts.model.Users;
import com.usts.service.IDataService;
import com.usts.service.IUserService;
import com.usts.service.impl.ExportService;
import com.usts.tools.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
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
        returnMap = new SqlToMap().convertMap(dataObject);
        return  returnMap;
    }

    // 根据单一的属性查找所有的数据
    @RequestMapping(value = "/listSingleData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listSingleData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        if (!isAviable(map)){
            return returnMap;
        }
        String sx = null;
        if (map.get("chaxun")!=null){
           sx = map.get("chaxun").toString();
        }
        int lb = Integer.parseInt(map.get("lb").toString());
        DataObject dataObject = new DataObject();
        dataObject.setLb(lb);
        dataObject.setSxkey(sx);
        List<DataObject> dataObjects = iDataService.selectDataByObject(dataObject);
        if (dataObjects.isEmpty()){
            dataObject.setSxkey(null);
            dataObject.setRiqi(sx);
            dataObjects = iDataService.selectDataByObject(dataObject);
            if (dataObjects.isEmpty()){
                dataObject.setRiqi(null);
                dataObject.setCydw(sx);
                dataObjects = iDataService.selectDataByObject(dataObject);
            }
        }
        returnMap = new SqlToMap().convertMap(dataObjects);
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
        returnMap = new SqlToMap().convertMap(dataObjects);
        return  returnMap;

    }

    // 增加一条数据
    @RequestMapping(value = "/addData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody

    public DataObject addData(@RequestBody Map map) {
        int label=0;
        String category;
        Map<String, Object> returnMap = new HashMap<>();
        DataObject dataObject = MapConvertObject.mapConvertDataObject(map);
        dataObject.setCyd_bh(map.get("cyd_bh").toString());
        dataObject.setCydw(map.get("cyd").toString());
        dataObject.setRiqi(map.get("jcd_time").toString());
        dataObject.setSxkey(map.get("sxkey").toString());
        dataObject.setSxvalue(Double.parseDouble(map.get("number").toString()));
        //dataObject.setLb(100);
        DefineLable dl=new DefineLable();
        System.out.println(dataObject.getSxkey());
        System.out.println(dl.defineLb(dataObject.getSxkey(),map.get("value1").toString()));
        dataObject.setLb(dl.defineLb(dataObject.getSxkey(),map.get("value1").toString()));
        System.out.println(dataObject);
        iDataService.addData(dataObject);
        return dataObject;
    }
//    public Map addData(@RequestBody Map map) {
//        Map<String, Object> returnMap = new HashMap<>();
//
//        return  returnMap;
//    }

    // 删除一条数据
    @RequestMapping(value = "/delData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public DataObject delData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        DataObject dataObject=new DataObject();
        String cyd_bh=map.get("cyd_bh").toString();
        String riqi=map.get("jcd_time").toString();
        String sxkey=map.get("sxkey").toString();
        System.out.println("cyd_bh"+cyd_bh);
        System.out.println("jcd_time"+riqi);
        System.out.println("sxkey"+sxkey);

        iDataService.delData(cyd_bh,riqi,sxkey);

        return dataObject;
    }
//    public Map delData(@RequestBody Map map) {
//        Map<String, Object> returnMap = new HashMap<>();
//
//        return  returnMap;
//    }

    // 更新一条数据
    @RequestMapping(value = "/updateData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public DataObject updateData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        DataObject dataObject = MapConvertObject.mapConvertDataObject(map);
        dataObject.setCyd_bh(map.get("cyd_bh").toString());
        dataObject.setCydw(map.get("cyd").toString());
        dataObject.setRiqi(map.get("jcd_time").toString());
        dataObject.setSxkey(map.get("sxkey").toString());
        dataObject.setSxvalue(Double.parseDouble(map.get("number").toString()));
        DefineLable dl=new DefineLable();
        System.out.println("sxkey:"+dataObject.getSxkey());
        System.out.println("label:"+dl.defineLb(dataObject.getSxkey(),map.get("value1").toString()));
        dataObject.setLb(dl.defineLb(dataObject.getSxkey(),map.get("value1").toString()));
        System.out.println("Selected Label:"+map.get("value1").toString());
        System.out.println(dataObject);
        iDataService.updataData(dataObject);

        return dataObject;
    }
//    public Map updataData(@RequestBody Map map) {
//        Map<String, Object> returnMap = new HashMap<>();
//
//        return  returnMap;
//    }

    @RequestMapping(value = "/statisticData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map statisticData(@RequestBody Map map){
        Map<String,Object> returnMap = new HashMap<>();
        // 权限验证
        if (map.get("jcd")!=null&&map.get("sxkey")!=null){
            DataObject dataObject = new DataObject();
            dataObject.setCydw(map.get("jcd").toString());
            dataObject.setLb(Integer.parseInt(map.get("sxkey").toString()));
            List<DataObject> objects = this.iDataService.selectDataByObject(dataObject);
            HashMap<String,ArrayList<DataObject>> cydMap = Tool.dividBySx((ArrayList<DataObject>) objects);
            ArrayList<PicModel> picList = new ArrayList<>();
            ArrayList<String> lb = new ArrayList<>();
            for (String s: cydMap.keySet()){
                HashMap<String,Double> value = Tool.dividByValue(cydMap.get(s));

                ArrayList<String> time = new ArrayList<>();
                ArrayList<Double> sxvalue = new ArrayList<>();
                for (String s1:value.keySet()){
                    time.add(s1);
                    sxvalue.add(value.get(s1));
                }
                Collections.sort(time);
                returnMap.put("time",time);
                PicModel picModel = new PicModel();
                picModel.setName(s);
                picModel.setData(sxvalue);
                picList.add(picModel);
                lb.add(s);
            }
            returnMap.put("lb",lb);
            returnMap.put("data",picList);
        }
        return returnMap;
    }

    private boolean isAviable(Map map){
        try {
            if (map.get("userid")!=null&&map.get("lb")!=null) {
                int userid = Integer.parseInt(map.get("userid").toString());
                Users users = iUserService.selectUser(userid);
                System.out.println("userid:"+map.get("userid")+"lb: "+map.get("lb")+"auth: "+users.getAuth());
                if (users.getAuth().contains(Integer.parseInt(map.get("lb").toString()))){
                    users = null;
                    return true;
                }else {
                    return false;
                }
            } else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }

    @Autowired
    private ExportService exportService;


    @RequestMapping(value = "/excel/export")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//        System.out.println(request.getParameter("value5"));
        DataObject dataObject = new DataObject();
        dataObject.setRiqi(request.getParameter("value11"));
        dataObject.setLb(Integer.parseInt(request.getParameter("value5")));
        List<DataObject> list = this.iDataService.selectDataByObject(dataObject);
        HSSFWorkbook wb = exportService.export(list);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename="+dataObject.getRiqi()+dataObject.getLb()+".xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }
}

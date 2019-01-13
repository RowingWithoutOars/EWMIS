package com.usts.tools;

import com.usts.model.DataObject;
import com.usts.model.ZBObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 将数据中取出的数据格式化成前台需要的数据格式
 * @author
 */
public class SqlToMap {

    private  HashMap<String,String> jcd = new HashMap<>();
    private  HashMap<String,String> jcd_time = new HashMap<>();
    private  HashMap<String,String> sxkey = new HashMap<>();
    private  int LB = -1;
    private  HashMap<String,String> point1 = new HashMap<>();
    private  HashMap<String,String> point2 = new HashMap<>();
    private  HashMap<String,String> address = new HashMap<>();
    // 将单个数据处理成目标格式
    public  Map convertMap(DataObject dataObject){
        clearMap();
        LB = dataObject.getLb();
        Map returnMap = new HashMap();
        List datalist = new ArrayList();
        loadData(dataObject,datalist);
        inputData(returnMap,datalist);
        return returnMap;
    }
    //zhuan huan zuobiao
    public  Map ConvertMap(ZBObject zbObject){
        Map returnMap = new HashMap();
        List datalist=new ArrayList();
        loadData(zbObject,datalist);
        inputZbData(returnMap,datalist);
        return returnMap;
    }

    //将多个数据转化成目标格式
    public  Map convertMap(List<DataObject> dataObjectList){
        Map returnMap = new HashMap();
        List datalist = new ArrayList();
        for (DataObject dataObject: dataObjectList){
            LB = dataObject.getLb();
            loadData(dataObject,datalist);
        }
        inputData(returnMap,datalist);
        return returnMap;
    }

    public  Map zbconvertMap(List<ZBObject> zbObjectList){
        Map returnMap = new HashMap();
        List datalist = new ArrayList();
        for (ZBObject zbObject: zbObjectList){
            loadData(zbObject,datalist);
        }
        inputData(returnMap,datalist);
        return returnMap;
    }

    private void clearMap(){
        jcd.clear();
        jcd_time.clear();
        sxkey.clear();
    }
    private void loadData(DataObject dataObject,List datalist){
        datalist.add(dataObject);
        jcd.put(dataObject.getCydw(),dataObject.getCydw());
        jcd_time.put(dataObject.getRiqi(),dataObject.getRiqi());
        sxkey.put(dataObject.getSxkey(),dataObject.getSxkey());
    }
    private void loadData(ZBObject zbObject,List datalist){
        datalist.add(zbObject);
        point1.put(zbObject.getPoint1(),zbObject.getPoint1());
        point2.put(zbObject.getPoint2(),zbObject.getPoint2());
        address.put(zbObject.getAddress(),zbObject.getAddress());
    }

    private void inputData(Map returnMap, List datalist){
        returnMap.put("data",datalist);
        returnMap.put("jcd", convertToTupleList(jcd));
        returnMap.put("jcd_time",convertToTupleList(jcd_time));
        returnMap.put("sxkey",convertToTupleList(sxkey));
        returnMap.put("lb",LB);
    }

    private void inputZbData(Map returnMap, List datalist){
        returnMap.put("data",datalist);
        returnMap.put("point1", convertToTupleList(point1));
        returnMap.put("point2",convertToTupleList(point2));
        returnMap.put("address",convertToTupleList(address));
    }

    private List<Tuple> convertToTupleList(HashMap<String,String> map1){
        List<Tuple> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map1.entrySet()){
            list.add(new Tuple(map1.get(entry.getKey())));
        }
        Tool.removeDuplicate((ArrayList) list);
        return list;
    }
}

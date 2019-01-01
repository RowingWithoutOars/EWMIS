package com.usts.tools;

import com.usts.model.DataObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 将数据中取出的数据格式化成前台需要的数据格式
 * @author
 */
public class SqlToMap {

    private static HashMap<String,String> jcd = new HashMap<>();
    private static HashMap<String,String> jcd_time = new HashMap<>();
    private static HashMap<String,String> sxkey = new HashMap<>();
    private static int LB = -1;
    // 将单个数据处理成目标格式
    public static Map convertMap(DataObject dataObject){
        clearMap();
        LB = dataObject.getLb();
        Map returnMap = new HashMap();
        List datalist = new ArrayList();
        loadData(dataObject,datalist);
        inputData(returnMap,datalist);
        return returnMap;
    }

    //将多个数据转化成目标格式
    public static Map convertMap(List<DataObject> dataObjectList){
        Map returnMap = new HashMap();
        List datalist = new ArrayList();
        for (DataObject dataObject: dataObjectList){
            LB = dataObject.getLb();
            loadData(dataObject,datalist);
        }
        inputData(returnMap,datalist);
        return returnMap;
    }

    private static void clearMap(){
        jcd.clear();
        jcd_time.clear();
        sxkey.clear();
    }
    private static void loadData(DataObject dataObject,List datalist){
        datalist.add(dataObject);
        jcd.put(dataObject.getCydw(),dataObject.getCydw());
        jcd_time.put(dataObject.getRiqi(),dataObject.getRiqi());
        sxkey.put(dataObject.getSxkey(),dataObject.getSxkey());
    }

    private static void inputData(Map returnMap, List datalist){
        returnMap.put("data",datalist);
        returnMap.put("jcd", convertToTupleList(jcd));
        returnMap.put("jcd_time",convertToTupleList(jcd_time));
        returnMap.put("sxkey",convertToTupleList(sxkey));
        returnMap.put("lb",LB);
    }

    private static List<Tuple> convertToTupleList(HashMap<String,String> map1){
        List<Tuple> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map1.entrySet()){
            list.add(new Tuple(map1.get(entry.getKey())));
        }
        return list;
    }
}

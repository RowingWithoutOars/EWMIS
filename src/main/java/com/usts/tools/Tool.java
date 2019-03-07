package com.usts.tools;

import com.usts.model.DataObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Tool {
    public static void removeDuplicate(ArrayList list){
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
    }

    public static HashMap<String,ArrayList<DataObject>> dividByCyd(ArrayList<DataObject> dataObjectList){
        HashMap<String,ArrayList<DataObject>> cydw = new HashMap<>();
        for (DataObject dataObject: dataObjectList){
            if (cydw.get(dataObject.getCydw())==null){
                cydw.put(dataObject.getCydw(),new ArrayList<DataObject>());
            }
            cydw.get(dataObject.getCydw()).add(dataObject);
        }
        return cydw;
    }

    public static HashMap<String,ArrayList<DataObject>> dividBySx(ArrayList<DataObject> dataObjects){
        // 按照类别将所有的分开
        Collections.sort(dataObjects);
        HashMap<String,ArrayList<DataObject>> sx = new HashMap<>();
        for (DataObject dataObject:dataObjects){
            if (sx.get(dataObject.getSxkey())==null)
                sx.put(dataObject.getSxkey(),new ArrayList<DataObject>());
            sx.get(dataObject.getSxkey()).add(dataObject);
        }
        return  sx;
    }

    public static HashMap<String, Double> dividByValue(ArrayList<DataObject> dataObjects){
        HashMap<String,Double> sx = new HashMap<>();
        for (DataObject dataObject:dataObjects){
            if (sx.get(dataObject.getRiqi())==null){
                sx.put(dataObject.getRiqi(),dataObject.getSxvalue());
            }
        }
        return sx;
    }
}

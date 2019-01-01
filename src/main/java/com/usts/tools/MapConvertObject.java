package com.usts.tools;

import com.usts.model.DataObject;

import java.util.Map;

public class MapConvertObject {
    public static DataObject mapConvertDataObject(Map map){
        DataObject dataObject = new DataObject();
        if (map.get("cyd_bh")!=null)
            dataObject.setCyd_bh(map.get("cyd_bh").toString());
        if (map.get("cydw")!=null)
            dataObject.setCydw(map.get("cydw").toString());
        if (map.get("riqi")!=null)
            dataObject.setRiqi(map.get("riqi").toString());
        return dataObject;
    }
}

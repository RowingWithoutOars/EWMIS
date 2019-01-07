package com.usts.tools;

import com.usts.model.DataObject;
import com.usts.model.Users;

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

    public static Users mapConverUsers(Map map){
        Users users = new Users();
        if (map.get("userid")!=null){
            users.setUserid(Integer.parseInt(map.get("userid").toString()));
        }
        if (map.get("username")!=null){
            users.setUsername(map.get("username").toString());
        }
        if (map.get("userpw")!=null){
            users.setUserpw(map.get("userpw").toString());
        }
        if (map.get("lb")!=null){
            users.setLb(map.get("lb").toString());
        }
        return users;
    }
}

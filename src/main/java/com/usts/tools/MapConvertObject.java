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
        if (map.get("fydw")!=null){
            users.setFydw(Integer.parseInt(map.get("fydw").toString()));
        }
        if (map.get("fyzw")!=null){
            users.setFyzw(Integer.parseInt(map.get("fyzw").toString()));
        }
        if (map.get("dq")!=null){
            users.setDq(Integer.parseInt(map.get("dq").toString()));
        }
        if (map.get("wsw")!=null){
            users.setWsw(Integer.parseInt(map.get("wsw").toString()));
        }
        if (map.get("dn")!=null){
            users.setDn(Integer.parseInt(map.get("dn").toString()));
        }
        if (map.get("other")!=null){
            users.setOther(Integer.parseInt(map.get("other").toString()));
        }
        return users;
    }
}

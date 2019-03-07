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
        if (map.get("username")!=null&&map.get("username").toString().length()>0){
            users.setUsername(map.get("username").toString());
        }
        if (map.get("userpw")!=null&&map.get("userpw").toString().length()>0){
            users.setUserpw(map.get("userpw").toString());
        }
        if (map.get("fydw")!=null&&map.get("fydw").toString().length()>0){
            users.setFydw(Integer.parseInt(map.get("fydw").toString()));
        }
        if (map.get("fyzw")!=null&&map.get("fyzw").toString().length()>0){
            users.setFyzw(Integer.parseInt(map.get("fyzw").toString()));
        }
        if (map.get("dq")!=null&&map.get("dq").toString().length()>0){
            users.setDq(Integer.parseInt(map.get("dq").toString()));
        }
        if (map.get("wsw")!=null&&map.get("wsw").toString().length()>0){
            users.setWsw(Integer.parseInt(map.get("wsw").toString()));
        }
        if (map.get("dn")!=null&&map.get("dn").toString().length()>0){
            users.setDn(Integer.parseInt(map.get("dn").toString()));
        }
        if (map.get("other")!=null&&map.get("other").toString().length()>0){
            users.setOther(Integer.parseInt(map.get("other").toString()));
        }
        if (map.get("phone")!=null&&map.get("phone").toString().length()>0){
            users.setPhone(map.get("phone").toString());
        }
        return users;
    }
}

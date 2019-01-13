package com.usts;

import com.usts.dao.DataDao;
import com.usts.dao.IUserDao;
import com.usts.model.DataObject;
import com.usts.model.LBObject;
import com.usts.model.Users;
import com.usts.tools.Tool;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class Test {

    @Autowired
    private DataDao dataDao;

    @org.junit.Test
    public void testSelectID(){
//        int id = 1;
//        Object object = dataDao.selectData(id);
//        System.out.println(object);

//        List<DataObject> list = dataDao.selectDataBySingle("2018.03");
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }
        DataObject dataObject = new DataObject();
        dataObject.setRiqi("2018.03");
        dataObject.setLb(200);
        System.out.println(dataObject.toString());
        List<DataObject> list = dataDao.selectDataByObject(dataObject);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @
    Autowired
    private IUserDao userDao;
    @org.junit.Test
    public void testUserFun(){
        Users users = new Users("Test1","Test1");
        users = this.userDao.selectUserByInfo(users);
        System.out.println(users.toString());
//        Users users1 = this.userDao.selectUser(17);
//        System.out.println(users1.toString());
//        System.out.println(users1.getAuth().size());
//        Map map = new HashMap<>();
//        map.put("userid",1);
//        map.put("sxkey", 200);
//        int sxkey = -1;
//        if (map.get("sxkey")!=null){
//            // 此处需要进行权限判断
//            sxkey = Integer.parseInt(map.get("sxkey").toString());
//        }else{
//            sxkey = 100;
//        }
//        List<DataObject> dataObjectList = this.dataDao.selectDataByLb(sxkey);
//        HashMap<String,ArrayList<DataObject>> ha = Tool.dividByCyd((ArrayList<DataObject>) dataObjectList);
//        for (String s: ha.keySet()){
//            System.out.println(s);
//        }

    }

    @org.junit.Test
    public void staticsData(){
        String s = "%浮游植物%";
        List<LBObject> list = dataDao.selectDatafuzzy(s);
        for(LBObject l:list){
            System.out.println(l.toString());
        }
    }
}

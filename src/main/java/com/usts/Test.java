package com.usts;

import com.usts.dao.DataDao;
import com.usts.dao.IUserDao;
import com.usts.model.DataObject;
import com.usts.model.LBObject;
import com.usts.model.Users;
import com.usts.service.IDataService;
import com.usts.tools.Auth;
import com.usts.tools.DefineLable;
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
//        Users users = new Users("Test1","Test1");
//        users = this.userDao.selectUserByInfo(users);
//        System.out.println(users.toString());
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

//        // 权限测试
//        try {
//            int userid = 2;// 获取到用户的id
//            Users users = this.userDao.selectUser(userid);
//            System.out.println("userid: "+userid +"Auth: "+users.getAuth());// 从数据库中获取用户权限
//            int lb = 100; // 数据类别
////            if (users.getAuth().contains(lb)){
////                    System.out.println(lb);
////            }
//            for (String str : Auth.getAuth().keySet()){
//               if (Auth.getAuth().get(str).contains(lb)){
//                   System.out.println(str+";"+ lb);
//                   System.out.println(users.getRoleAuth().get(str));
//               }
//            }
//        }catch (Exception e){
////            return -1;
//        }
        DefineLable defineLable = new DefineLable();
        int a = defineLable.defineSelfLb("桡足类","密度");
        System.out.println(a);
        DataObject dataObject = new DataObject();
        dataObject.setLb(a);
        List<DataObject> dataObjects = this.dataDao.selectDataByObject(dataObject);
        System.out.println(dataObjects.size());
    }

    @Autowired
    private IDataService iDataService;
    @org.junit.Test
    public void testDataDun(){
//        DataObject dataObject = new DataObject();
//        dataObject = iDataService.selectData(1);
//        System.out.println(dataObject);
//        dataObject.setSxvalue(11111);
//        iDataService.updataData(dataObject);
//        ArrayList<DataObject> dataObjects = new ArrayList<>();
//        dataObjects = (ArrayList<DataObject>) this.iDataService.selectDataByLb(0);
//        System.out.println(dataObjects.get(0));
//        for (DataObject dataObject:dataObjects){
//            dataObject.setStatus(0);
//        }
//        this.iDataService.addDataBench(dataObjects);
        String str = "%20%";
        ArrayList<String> rq = (ArrayList<String>)this.dataDao.selectRiQi(str);
//        Tool.removeDuplicate(rq);
        System.out.println(rq.size());
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

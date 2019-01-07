package com.usts;

import com.usts.dao.DataDao;
import com.usts.dao.IUserDao;
import com.usts.model.DataObject;
import com.usts.model.LBObject;
import com.usts.model.Users;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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
//        List<Users> users = userDao.listUser();
//        for(Users user:users){
//            System.out.println(user);
//        }
        Users users1 = new Users();
        users1.setUserid(13);
//        users1.setLb("40");
        users1.setUserpw("222222222");
        this.userDao.updataUserPasswd(users1);
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

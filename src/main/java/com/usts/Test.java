package com.usts;

import com.usts.dao.DataDao;
import com.usts.dao.IUserDao;
import com.usts.model.DataObject;
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
        int i = 12;
        Users users = userDao.selectUser(i);
        System.out.println(users);
        users.setUserpw("222222");
        this.userDao.updataUserPasswd(users);
        users.setUsername("Test13");
        users.setUserpw("333333");
        this.userDao.addUsers(users);
        Users user2 = this.userDao.selectUserByInfo(users);
        System.out.println(user2);
    }
}

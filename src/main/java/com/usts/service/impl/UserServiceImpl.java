package com.usts.service.impl;

import com.usts.dao.IUserDao;
import com.usts.model.Users;
import com.usts.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service()
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public Users selectUser(int userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public List<Users> listUser() {
        return this.userDao.listUser();
    }

    @Override
    public Users selectUserByInfo(Users users) {
        return this.userDao.selectUserByInfo(users);
    }

    @Override
    public void addUsers(Users user) {
        this.userDao.addUsers(user);
    }

//    @Override
//    public void addUsers(String name, String passwd, String userType) {
//        this.userDao.addUsers(name,passwd,userType);
//    }

    @Override
    public void deleteUsers(Users user) {
        this.userDao.deleteUsers(user);
    }

    @Override
    public void updataUserPasswd(Users users) {
        this.userDao.updataUserPasswd(users);
    }
}
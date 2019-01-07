package com.usts.service;

import com.usts.model.Users;

import java.util.List;

public interface IUserService {

    public Users selectUser(int userId);
    public List<Users> listUser();

    public Users selectUserByInfo(Users users);

    // 增加用户
    public void addUsers(Users user);

//    public void addUsers(String name,String passwd,String userType);

    // 用户注销
    public void deleteUsers(Users user);

    public void updataUserPasswd(Users users);
}
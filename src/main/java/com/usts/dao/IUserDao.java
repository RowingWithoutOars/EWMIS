package com.usts.dao;

import com.usts.model.Users;

import java.util.List;

public interface IUserDao {

    Users selectUser(int id);
    List<Users> listUser();
    Users selectUserByInfo(Users users);
    void addUsers(Users user);
    void deleteUsers(Users user);
    void updataUserPasswd(Users users);
}
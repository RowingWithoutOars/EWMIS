package com.usts.dao;

import com.usts.model.Users;

public interface IUserDao {

    Users selectUser(int id);
    Users selectUserByInfo(Users users);
    void addUsers(Users user);
    void deleteUsers(Users user);
    void updataUserPasswd(Users users);
}
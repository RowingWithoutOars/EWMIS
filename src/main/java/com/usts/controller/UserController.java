package com.usts.controller;

import com.alibaba.fastjson.JSONObject;
import com.usts.model.Users;
import com.usts.service.IUserService;
import com.usts.tools.MapConvertObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    // 登录接口
    @RequestMapping(value = "/login", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map login(@RequestBody Map map) {
        String userName = map.get("username").toString();
        String passWord = map.get("password").toString();
//        System.out.println(userName+";"+passWord);
        Users user = new Users(userName,passWord);
        user = this.userService.selectUserByInfo(user);
//        System.out.println(user);
        Map reMap = new HashMap();
        if (user!=null){
            reMap.put("code",200);
            reMap.put("userid",user.getUserid());
        }
        return reMap;
    }

    // 列出所有用户信息
    @RequestMapping(value = "/listusers", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listUser() {
        Map<String, Object> returnMap = new HashMap<>();
        List<Users> users = this.userService.listUser();
        returnMap.put("data",users);
        return  returnMap;
    }

    // 增加一个用户信息
    @RequestMapping(value = "/adduser", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public void addUser(@RequestBody Map map) {
        for (Object o:map.keySet()){
            System.out.println("关键字："+o+";  值 "+map.get(o).toString());
        }
        Users user = MapConvertObject.mapConverUsers(map);
        this.userService.addUsers(user);
    }

    // 删除用户信息
    @RequestMapping(value = "/deluser", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public void delUser(@RequestBody Map map) {
        System.out.println("删除函数");
        for (Object o:map.keySet()){
            System.out.println("关键字："+o+";  值 "+map.get(o).toString());
        }
        Users user = MapConvertObject.mapConverUsers(map);
        System.out.println(user);
        this.userService.deleteUsers(user);
    }

    // 修改用户信息
    @RequestMapping(value = "/updateuser", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public void updateUser(@RequestBody Map map) {
        for (Object o:map.keySet()){
            System.out.println("关键字："+o+";  值 "+map.get(o).toString());
        }
        Users user = MapConvertObject.mapConverUsers(map);
        System.out.println(user);
        this.userService.updataUserPasswd(user);
    }
}
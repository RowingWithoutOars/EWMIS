package com.usts.controller;

import com.alibaba.fastjson.JSONObject;
import com.usts.model.Users;
import com.usts.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    // 登录接口
    @RequestMapping(value = "/login.do", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Object login(@RequestBody Map map) {
        String userName = map.get("username").toString();
        String passWord = map.get("userpw").toString();
        Users user = new Users(userName,passWord);
                this.userService.selectUserByInfo(user);
        JSONObject jsonObject = new JSONObject();
        if (user != null && user.getUserpw().equals(passWord)){
            jsonObject.put("code",200);
            user.setUserpw("");
            jsonObject.put("user",user);
            return jsonObject;
        }
        else{
            System.out.println("login faile");
            return jsonObject;
        }
    }


}
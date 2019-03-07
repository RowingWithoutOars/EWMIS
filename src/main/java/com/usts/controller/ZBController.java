package com.usts.controller;

import com.usts.model.ZBObject;
import com.usts.service.IZBService;
import com.usts.tools.SqlToMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zbdata")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ZBController {

    @Autowired
    private IZBService iZBService;


    //根据id查找对应的一条数据
    @RequestMapping(value = "/listData", produces = "application/json; charset=utf-8")
    @ResponseBody
    @CrossOrigin(origins = "*", maxAge = 3600)
    public Map listData() {
        Map<String, Object> returnMap = new HashMap<>();
        ZBObject zbObject = iZBService.selectAll(1);
        System.out.println(zbObject);
        returnMap = new SqlToMap().ConvertMap(zbObject);
        return returnMap;
    }


    // 根据单一的属性查找所有的数据
    @RequestMapping(value = "/listSingleData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listSingleData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        if (map != null) {
            // 遍历Map中的属性值
            int lb = Integer.parseInt(map.get("lb").toString());
            List<ZBObject> zbObject = iZBService.selectDataBySingle(lb);
            returnMap = new SqlToMap().zbconvertMap(zbObject);
        }
        return returnMap;

    }


}

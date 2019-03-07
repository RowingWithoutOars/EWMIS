package com.usts.service;

import com.usts.model.ZBObject;

import java.util.List;

public interface IZBService {

    // 根据id查找单个数据
    public ZBObject selectAll(int id);

    // 根据属性查找属性，直接放入cyd_bh,cydw,riqi,key都是可以的
    public List<ZBObject> selectDataBySingle(int lb);
//
//    // 根据多个属性值查找对应的结果
//    public List<DataObject> selectDataByObject(DataObject dataObject);
//
//    // 根据字符查类别
//    public List<LBObject> selectDatafuzzy(String lbkey);
//
//    // 增加一行属性，每次增加一个
//    public void addData(DataObject dataObject);
//
//    // 更新数据，每次只更新一个，一整条记录通过遍历一个List完成
//    public void updataData(DataObject dataObject);
//
//    // 删除数据，就是把回溯标志位改成0
//    public void delData(int id);



}

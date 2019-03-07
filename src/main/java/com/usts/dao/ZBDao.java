package com.usts.dao;

import com.usts.model.ZBObject;

import java.util.List;

public interface ZBDao {
    public ZBObject selectAll(int id);


    public List<ZBObject> selectDataBySingle(int lb);

//    public List<DataObject> selectDataByObject(DataObject dataObject);
//
//    public List<LBObject> selectDatafuzzy(String lbkey);
//
//    public void addData(DataObject dataObject);
//
//    public void updataData(DataObject dataObject);
//
//    public void delData(int id);
}

package com.usts.dao;

import com.usts.model.DataObject;

import java.util.List;

public interface DataDao {
    public DataObject selectData(int id);

    public List<DataObject> selectDataBySingle(String sx);

    public List<DataObject> selectDataByObject(DataObject dataObject);

    public void addData(DataObject dataObject);

    public void updataData(DataObject dataObject);

    public void delData(int id);
}

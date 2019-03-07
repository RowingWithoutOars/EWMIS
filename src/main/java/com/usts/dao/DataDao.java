package com.usts.dao;

import com.usts.model.DataObject;
import com.usts.model.LBObject;

import java.util.ArrayList;
import java.util.List;

public interface DataDao {
    public DataObject selectData(int id);

    public List<DataObject> selectDataBySingle(String sx);

    public List<DataObject> selectDataByObject(DataObject dataObject);

    public List<DataObject> selectDataByLb(int lb);

    public List<LBObject> selectDatafuzzy(String lbkey);

    public List<String> selectRiQi(String riqi);

    public void addData(DataObject dataObject);

    public int addDataBench(ArrayList<DataObject> dataObjects);

    public void updataData(DataObject dataObject);

    public void delData(String cyd_bh,String riqi,String sxkey);

//    public void delData(int id);
}

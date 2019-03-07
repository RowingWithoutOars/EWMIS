package com.usts.service.impl;

import com.usts.dao.DataDao;
import com.usts.model.DataObject;
import com.usts.model.LBObject;
import com.usts.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService implements IDataService {

    @Autowired
    private DataDao dataDao;

    @Override
    public DataObject selectData(int id) {
        return this.dataDao.selectData(id);
    }

    @Override
    public List<DataObject> selectDataBySingle(String sx) {
        return this.dataDao.selectDataBySingle(sx);
    }

    @Override
    public List<DataObject> selectDataByLb(int lb) {
        return this.dataDao.selectDataByLb(lb);
    }

    @Override
    public List<DataObject> selectDataByObject(DataObject dataObject) {
        return this.dataDao.selectDataByObject(dataObject);
    }

    @Override
    public List<LBObject> selectDatafuzzy(String lbkey) {
        return this.dataDao.selectDatafuzzy(lbkey);
    }

    @Override
    public List<String> selectRiQi(String riqi) {
        return this.dataDao.selectRiQi("%"+riqi+"%");
    }

    @Override
    public void addData(DataObject dataObject) {
        this.dataDao.addData(dataObject);
    }

    @Override
    public int addDataBench(ArrayList<DataObject> dataObjects) {
        return this.dataDao.addDataBench(dataObjects);
    }

    @Override
    public void updataData(DataObject dataObject) {
        this.dataDao.updataData(dataObject);
    }

    @Override
    public void delData(String cyd_bh,String riqi,String sxkey) {
        this.dataDao.delData(cyd_bh,riqi,sxkey);
    }

//    public void delData(int id) {
//        this.delData(id);
//    }
}

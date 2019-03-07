package com.usts.service.impl;

import com.usts.dao.ZBDao;
import com.usts.model.ZBObject;
import com.usts.service.IZBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZBService implements IZBService {

    @Autowired
    private ZBDao zbDao;

    @Override
    public ZBObject selectAll(int id) {
        return this.zbDao.selectAll(id);
    }

    @Override
    public List<ZBObject> selectDataBySingle(int lb) {
        return this.zbDao.selectDataBySingle(lb);
    }


//    @Override
//    public List<DataObject> selectDataByObject(DataObject dataObject) {
//        return this.dataDao.selectDataByObject(dataObject);
//    }
//
//    @Override
//    public List<LBObject> selectDatafuzzy(String lbkey) {
//        return this.dataDao.selectDatafuzzy(lbkey);
//    }
//
//    @Override
//    public void addData(DataObject dataObject) {
//        this.dataDao.addData(dataObject);
//    }
//
//    @Override
//    public void updataData(DataObject dataObject) {
//        this.dataDao.updataData(dataObject);
//    }
//
//    @Override
//    public void delData(int id) {
//        this.delData(id);
//    }
}

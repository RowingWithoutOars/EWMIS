package com.usts.service.impl;
import com.usts.model.DataObject;
import com.usts.tools.DefineLable;
import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ImportService {
    //读取excel数据
    public ArrayList<DataObject> readExcel(String path) throws IOException {
        ArrayList<DataObject> dataObjects = new ArrayList<>();
        InputStream is = new FileInputStream(path);
        // 打开HSSFWorkbook
        POIFSFileSystem fs = new POIFSFileSystem(is);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        //获取sheet
        HSSFSheet st = wb.getSheetAt(0);
        //获取keyList
        ArrayList keyList = getKeyList(st);
        //一行一行读取数据

        ArrayList<String> headOne = getKey(st,0);// 双层表头的第一层
        ArrayList<String> headTwo = getKey(st,1);// 双层表头的第二层

        for (int i = 2; i < st.getLastRowNum() - 2; i++) {
            HSSFRow hssfRow = st.getRow(i);
            if (hssfRow.getCell(0) == null) {
                break;
            }
//            System.out.println(keyList.size());
            for (int j = 0; j < headOne.size(); j++) {
                DataObject dataObject = new DataObject();
                DefineLable defineLable=new DefineLable();
                dataObject.setCyd_bh(getValue(hssfRow.getCell(0)));
                dataObject.setCydw(getValue(hssfRow.getCell(1)));
                dataObject.setRiqi(getValue(hssfRow.getCell(2)));
                dataObject.setSxkey(getSxkey(headOne,headTwo,j));
                dataObject.setLb(getLb(headOne,headTwo,j,path));
//                if (dataObject.getLb()==0){
//                    System.out.println("============"+headOne.get(j)+";"+headTwo.get(j));
//                    System.exit(0);
//                }
//                dataObject.setLb();
//                System.out.println(headOne.get(j)+":"+headTwo.get(j)+";"+dataObject.getSxkey()+";"+j);
                try {
                    if (getValue(hssfRow.getCell(j + 4)) != null && !getValue(hssfRow.getCell(j + 4)).equals("")) {
                        dataObject.setSxvalue(Double.parseDouble(getValue(hssfRow.getCell(j + 4))));
                    } else {
                        dataObject.setSxvalue(0);
                    }
                }catch (NumberFormatException e){
                    dataObject.setSxvalue(0);
                }
                System.out.println(dataObject.getSxkey()+": "+dataObject.getLb());
//                dataObject.setLb(defineLable.defineLb(dataObject.getSxkey(),judgeLb(path)));
                dataObjects.add(dataObject);
            }
//            System.exit(0);
        }
        return dataObjects;
    }

    private String getSxkey(ArrayList<String> headOne,ArrayList<String> headTwo,int index){
        if (isMixTable(headOne,index)){
            return headTwo.get(index);
        }
        else if (headOne.get(index).equals(headTwo.get(index))){
            return headOne.get(index); //两个一样，那就是一级
        }else {
            return headTwo.get(index); // 两个不一样，那就是合并单元格了
        }
    }

    private int getLb(ArrayList<String> headOne,ArrayList<String> headTwo,int index,String path){
        DefineLable defineLable = new DefineLable();
//        if (headOne.get(index).equals(headTwo.get(index))){// 没有合并单元格
//            return defineLable.defineLb(headOne.get(index),judgeLb(filePath));
//        }else{
//        System.out.println(headOne.get(index)+"===="+isMixTable(headOne,index));
        String key = isMixTable(headOne,index)?headOne.get(index).trim():judgeLb(path);
//        System.out.println(key+"=====");
            return defineLable.defineLb(headTwo.get(index).trim(),key.trim());
//        }
    }

    private boolean isMixTable(ArrayList<String> headOne,int index){// 判断是否为生物量密度的混合表
        if (headOne.get(index).contains("密度")||headOne.get(index).contains("生物量")){
            return true;
        }
        return false;
    }

    //获取单元格的值
    public String getValue(HSSFCell hssfCell) {
        if (hssfCell!=null&&hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell!=null&&hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        }  else {
            return String.valueOf(hssfCell!=null?hssfCell.getStringCellValue():"");
        }
    }

    //将所有的key放到一个list里
    private ArrayList<String> getKeyList(HSSFSheet hssfSheet) {
        ArrayList<String> keyList = new ArrayList<>();
        HSSFRow hssfRow1 = hssfSheet.getRow(0);

        for (int i = 3; i < hssfRow1.getLastCellNum(); i++) {
            HSSFCell hssfCell;
            hssfCell = hssfRow1.getCell(i);
            if (hssfCell.getStringCellValue() == null || hssfCell.getStringCellValue().equals("")) {
                HSSFRow hssfRow0 = hssfSheet.getRow(0);
                hssfCell = hssfRow0.getCell(i);
            }
            String getv = getValue(hssfCell);
//            System.out.println(getv+"...");
            if (getv.equals("采样点")) {
                continue;
            } else {
                if(getv!=null&&getv.length()>0) {
                    keyList.add(getv);
                }
            }
        }
        return keyList;
    }
    //headRow用来表示第几行，仅可以传入0和1
    private ArrayList<String> getKey(HSSFSheet hssfSheet,int headRow) {
        ArrayList<String> keyList = new ArrayList<>();
        HSSFRow hssfRow1 = hssfSheet.getRow(headRow);
        String flag= ""; // 在合并单元格中，用来记录第一行的属性
//        System.out.println(hssfRow1.getLastCellNum());
        for (int i = 3; i < hssfRow1.getLastCellNum(); i++) {
            HSSFCell hssfCell;
            hssfCell = hssfRow1.getCell(i);
            if (hssfCell.getStringCellValue() == null || hssfCell.getStringCellValue().equals("")) {
                HSSFRow hssfRow0 = hssfSheet.getRow(0);
                hssfCell = hssfRow0.getCell(i);
            }
//            System.out.println(i);
            String getv = getValue(hssfCell);
            if (getv!=null&&getv.length()>0){
                flag = getv;
                keyList.add(getv);// 没有合并单元格，则记录这个值
            }else{
                keyList.add(flag);// 合并单元格后，所有并格单元值是一个
            }
        }
        return keyList;
    }


    //判断传过来是的密度还是生物量
    public String judgeLb(String fileName) {
        String result = "";
        if (fileName.contains("密度")) {
            result = "密度";
        }else if(fileName.contains("生物量")){
            result="生物量";
        }else if(fileName.contains("微生物")){
            result="微生物";
        }
        return result;
    }

    public static void main(String args[]){
//        String path = "/Users/usts/Desktop/modul/水质.xls";
//        String path = "/Users/usts/Desktop/modul/水生生物底栖.xls";
//        String path = "/Users/usts/Desktop/modul/水生生物浮游动物密度.xls";
//        String path = "/Users/usts/Desktop/modul/水生生物浮游动物生物量.xls";
//        String path = "/Users/usts/Desktop/modul/水生生物浮游植物生物量.xls";
//        String path = "/Users/usts/Desktop/modul/水生生物浮游植物密度.xls";
//        String path = "/Users/usts/Desktop/modul/底泥.xls";
        String path = "/Users/usts/Desktop/modul/微生物群落.xls";
        try {
            ArrayList<DataObject> result = new ImportService().readExcel(path);
//            System.out.println(result.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

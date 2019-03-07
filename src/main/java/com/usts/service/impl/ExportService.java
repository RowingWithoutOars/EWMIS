package com.usts.service.impl;

import com.usts.model.DataObject;
import com.usts.tools.Tool;
import com.usts.tools.Tuple;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Service
public class ExportService {


    public HSSFWorkbook export(List<DataObject> list) {
        String[] excelHeader = getHeader(list);

        HSSFWorkbook wb = new HSSFWorkbook();// 创建一个excel文件
        HSSFSheet sheet = wb.createSheet("sheet1");// 创建一个excel文件
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        for (int i = 0; i < excelHeader.length; i++) {
            HSSFCell cell1 = row.createCell(i);
            cell1.setCellValue(excelHeader[i]);
            cell1.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
        HashMap<String,ArrayList<DataObject>> dividCydw = getContent(list);
        int count = 1;
        for (String s:dividCydw.keySet()) {
            row = sheet.createRow(count);
            row.createCell(0).setCellValue(s);// 设置地点信息
            String riqi = "";
            for (int i =0; i< dividCydw.get(s).size(); i++){
                riqi = dividCydw.get(s).get(i).getRiqi();
                row.createCell(i+2).setCellValue(dividCydw.get(s).get(i).getSxvalue());
            }
            row.createCell(1).setCellValue(riqi);// 设置时间
            count++;
        }
        return wb;
    }

    private static String[] getHeader(List<DataObject> list){
        ArrayList<String> l = new ArrayList<>();
        for (DataObject dataObject:list){
            l.add(dataObject.getSxkey());
        }
        Tool.removeDuplicate(l);
        String s[] = new String[l.size()+2];
        s[0] = "采样点";
        s[1] = "采样时间";
        for (int i=0; i<l.size(); i++){
            s[i+2] = l.get(i);
        }
        return s;
    }

    // 按点位分开，并排序
    private static HashMap<String,ArrayList<DataObject>> getContent(List<DataObject> list){
        HashMap<String,ArrayList<DataObject>> diviCydw = Tool.dividByCyd((ArrayList<DataObject>) list);
        for (String s:diviCydw.keySet()){
            diviCydw.get(s).sort(new Comparator<DataObject>() {
                @Override
                public int compare(DataObject o1, DataObject o2) {
                    return o1.getCydw().compareTo(o2.getCydw());
                }
            });
        }

        return diviCydw;
    }
}  
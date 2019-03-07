package com.usts.controller;

import com.usts.model.DataObject;
import com.usts.model.PicModel;
import com.usts.model.Users;
import com.usts.service.IDataService;
import com.usts.service.IUserService;
import com.usts.service.impl.ExportService;
import com.usts.service.impl.ImportService;
import com.usts.tools.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/data")
public class DataController {



    @Autowired
    private IDataService iDataService;

    @Autowired
    private IUserService iUserService;

    private DefineLable defineLable = new DefineLable();

    //根据id查找对应的一条数据
    @RequestMapping(value = "/listData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listData() {
        Map<String,Object> returnMap = new HashMap<>();
        DataObject dataObject = iDataService.selectData(1);
        returnMap = new SqlToMap().convertMap(dataObject);
        return  returnMap;
    }

    // 根据单一的属性查找所有的数据
    @RequestMapping(value = "/listSingleData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listSingleData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        if (isAviable(map)<1){
            returnMap.put("code",403);
            return returnMap;
        }
        String sx = null;
        if (map.get("chaxun")!=null){
           sx = map.get("chaxun").toString();
        }
        int lb = Integer.parseInt(map.get("lb").toString());
        DataObject dataObject = new DataObject();
        dataObject.setLb(lb);
        dataObject.setSxkey(sx);
        List<DataObject> dataObjects = iDataService.selectDataByObject(dataObject);
        if (dataObjects.isEmpty()) {
            dataObject.setSxkey(null);
            dataObject.setRiqi(sx);
            dataObjects = iDataService.selectDataByObject(dataObject);
            if (dataObjects.isEmpty()) {
                dataObject.setRiqi(null);
                dataObject.setCydw(sx);
                dataObjects = iDataService.selectDataByObject(dataObject);
            }
        }
        returnMap = new SqlToMap().convertMap(dataObjects);
        return returnMap;
    }

    // 根据多个属性查找所有的数据
    @RequestMapping(value = "/listDataByMOre", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map listMoreData(@RequestBody Map map) {
        Map returnMap = new HashMap<>();
        if (isAviable(map)<1){//小于1 不可以浏览
            returnMap.put("code",403);
            return returnMap;
        }
        String sx = null;
        if (map.get("chaxun")!=null){// 查询的属性值
            sx = map.get("chaxun").toString();
        }
        String zl = "";
        if (map.get("value1")!=null){// 设置数据种类
            zl = map.get("value1").toString();
        }
        int sonlb = defineLable.defineSelfLb(sx.trim(),zl);//获取到下一级的子类类别
        System.out.println("sonlb:" + sonlb+"; zl :"+zl);
        int flag = sonlb;
        if(sonlb>1000){
            sonlb = defineLable.defineLb(sx,zl);
        }
        if (sonlb>1000){
            if (map.get("lb")!=null){
                sonlb = Integer.parseInt(map.get("lb").toString());
            }
        }
        DataObject dataObject = new DataObject();
        dataObject.setLb(sonlb);
        List<DataObject> dataObjects = iDataService.selectDataByObject(dataObject);
        returnMap = new SqlToMap().convertMap(dataObjects);
        if (flag>1000){
            returnMap.put("code",404);
        }
        return  returnMap;

    }

    // 增加一条数据
    @RequestMapping(value = "/addData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map addData(@RequestBody Map map) {
        DataObject dataObject = MapConvertObject.mapConvertDataObject(map);
        Map<String, Object> returnMap = new HashMap<>();
        if (isAviable(map)<2){
            returnMap.put("code",403);
            return returnMap;
        }
        dataObject.setSxkey(map.get("sxkey").toString());
        dataObject.setSxvalue(Double.parseDouble(map.get("number").toString()));
        //dataObject.setLb(100);
        DefineLable dl=new DefineLable();
        System.out.println(dataObject.getSxkey());
        System.out.println(dl.defineLb(dataObject.getSxkey(),map.get("value1").toString()));
        dataObject.setLb(dl.defineLb(dataObject.getSxkey(),map.get("value1").toString()));
        System.out.println(dataObject);
        iDataService.addData(dataObject);
        returnMap.put("code",200);
        return returnMap;
    }
//    public Map addData(@RequestBody Map map) {
//        Map<String, Object> returnMap = new HashMap<>();
//
//        return  returnMap;
//    }

    // 删除一条数据
    @RequestMapping(value = "/delData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map delData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        System.out.println(isAviable(map));
        if (isAviable(map)<2){
            returnMap.put("code",403);
            return returnMap;
        }
        DataObject dataObject=new DataObject();
        String cyd_bh=map.get("cyd_bh").toString();
        String riqi=map.get("jcd_time").toString();
        String sxkey=map.get("sxkey").toString();
        System.out.println("cyd_bh"+cyd_bh);
        System.out.println("jcd_time"+riqi);
        System.out.println("sxkey"+sxkey);
        iDataService.delData(cyd_bh,riqi,sxkey);
        returnMap.put("code",200);
        return returnMap;
    }

    // 更新一条数据
    @RequestMapping(value = "/updateData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map updateData(@RequestBody Map map) {
        Map<String, Object> returnMap = new HashMap<>();
        if (isAviable(map)<2){
            returnMap.put("code",403);
            return returnMap;
        }
        DataObject dataObject = MapConvertObject.mapConvertDataObject(map);
        dataObject.setSxkey(map.get("sxkey").toString());
        dataObject.setSxvalue(Double.parseDouble(map.get("number").toString()));
        System.out.println(map.get("number"));
        DefineLable dl=new DefineLable();
        dataObject.setLb(dl.defineLb(dataObject.getSxkey(),map.get("value1").toString()));
        System.out.println(dataObject);
        iDataService.updataData(dataObject);
        returnMap.put("code",200);
        return returnMap;
    }

    @RequestMapping(value = "/statisticData", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map statisticData(@RequestBody Map map){
        Map<String,Object> returnMap = new HashMap<>();
        // 权限验证
        if (map.get("jcd")!=null&&map.get("sxkey")!=null){
            DataObject dataObject = new DataObject();
            dataObject.setCydw(map.get("jcd").toString());
            dataObject.setLb(Integer.parseInt(map.get("sxkey").toString()));
            List<DataObject> objects = this.iDataService.selectDataByObject(dataObject);
            HashMap<String,ArrayList<DataObject>> cydMap = Tool.dividBySx((ArrayList<DataObject>) objects);
            ArrayList<PicModel> picList = new ArrayList<>();
            ArrayList<String> lb = new ArrayList<>();
            for (String s: cydMap.keySet()){
                HashMap<String,Double> value = Tool.dividByValue(cydMap.get(s));

                ArrayList<String> time = new ArrayList<>();
                ArrayList<Double> sxvalue = new ArrayList<>();
                for (String s1:value.keySet()){
                    time.add(s1);
                    sxvalue.add(value.get(s1));
                }
                Collections.sort(time);
                returnMap.put("time",time);
                PicModel picModel = new PicModel();
                picModel.setName(s);
                picModel.setData(sxvalue);
                picList.add(picModel);
                lb.add(s);
            }
            returnMap.put("lb",lb);
            returnMap.put("data",picList);
        }else {
            returnMap.put("code",403);
        }
        return returnMap;
    }

    private int isAviable(Map map){
        try {
            if (map.get("userid")!=null&&map.get("lb")!=null) {
                int userid = Integer.parseInt(map.get("userid").toString());
                Users users = iUserService.selectUser(userid);
                System.out.println("userid:"+map.get("userid")+"lb: "+map.get("lb")+"auth: "+users.getAuth());
                int lb = Integer.parseInt(map.get("lb").toString());
                for (String str: Auth.getAuth().keySet()){
                    if (Auth.getAuth().get(str).contains(lb)){
//                        System.out.println(str+";"+ lb);
                        System.out.println(users.getRoleAuth().get(str));
                        return users.getRoleAuth().get(str);
                    }
                }
                return -1;
            } else {
                return -1;
            }
        }catch (Exception e){
            return -1;
        }
    }

    @RequestMapping(value = "/getRiqi", produces = "application/json; charset=utf-8")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public Map getRiqi(Map map){
        Map rq = new HashMap();
        String val = "";
        if (map.get("time")!=null&&map.get("time").toString().trim().length()>0){
            val = map.get("time").toString().trim();
        }else{
            val = "20";
        }
        ArrayList<String> res = (ArrayList<String>) this.iDataService.selectRiQi(val);
        rq.put("data",res);
        return rq;
    }


    @Autowired
    private ExportService exportService;


    @RequestMapping(value = "/excel/export")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    public void exportExcel(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DataObject dataObject = new DataObject();
        dataObject.setRiqi(request.getParameter("value11"));
        dataObject.setLb(Integer.parseInt(request.getParameter("value5")));
        List<DataObject> list = this.iDataService.selectDataByObject(dataObject);
        HSSFWorkbook wb = exportService.export(list);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename="+dataObject.getRiqi()+dataObject.getLb()+".xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


    @Autowired
    private ImportService importService;
    /**
     * 上传数据及保存文件
     */
    @RequestMapping(value = "/excel/import")
    @CrossOrigin(origins = "*", maxAge = 3600)
    @ResponseBody
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // 检测是否为多媒体上传
//        String dataType = "";
//        if (request.getParameterValues("dataType")!=null){
//            dataType = request.getParameterValues("dataType").toString();
//        }
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;

        String uploadFilePath = "";
        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        uploadFilePath = filePath;
                        // 保存文件到硬盘
                        item.write(storeFile);
                        System.out.println("文件上传成功");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
        ArrayList<DataObject> dataObjects = this.importService.readExcel(uploadFilePath);
        try {
            this.iDataService.addDataBench(dataObjects);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Done!");
    }
}

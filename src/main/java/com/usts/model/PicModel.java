package com.usts.model;

import com.usts.tools.Tuple2;

import java.util.ArrayList;
import java.util.HashMap;

public class PicModel {
    private String name = "";
    private String type = "line";
    private ArrayList<Integer> data = new ArrayList();
    private HashMap<String,ArrayList> markPoint = new HashMap<>();
    private HashMap<String,ArrayList> markLine = new HashMap<>();

    public PicModel() {
        ArrayList<Tuple2> point = new ArrayList<>();
        point.add(new Tuple2("max","最大值"));
        point.add(new Tuple2("min","最小值"));
        markPoint.put("data",point);

        ArrayList<Tuple2> line = new ArrayList<>();
        line.add(new Tuple2("average","平均值"));
        markLine.put("data",line);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }

    public HashMap<String, ArrayList> getMarkPoint() {
        return markPoint;
    }

    public void setMarkPoint(HashMap<String, ArrayList> markPoint) {
        this.markPoint = markPoint;
    }

    public HashMap<String, ArrayList> getMarkLine() {
        return markLine;
    }

    public void setMarkLine(HashMap<String, ArrayList> markLine) {
        this.markLine = markLine;
    }


}

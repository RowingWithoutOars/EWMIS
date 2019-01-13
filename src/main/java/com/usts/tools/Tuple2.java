package com.usts.tools;

public class Tuple2 {
    private String type = "";
    private  String name = "";

    public Tuple2(String text, String name) {
        this.type = text;
        this.name = name;
    }

    public Tuple2(String text) {
        this.type = text;
        this.name = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

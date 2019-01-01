package com.usts.tools;

public class Tuple {
    private String text = "";
    private  String value = "";

    public Tuple(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public Tuple(String text) {
        this.text = text;
        this.value = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package com.usts.model;

public class LBObject {
    private String sxkey = "";
    private int sxvalue = -1;

    public String getSxkey() {
        return sxkey;
    }

    public void setSxkey(String sxkey) {
        this.sxkey = sxkey;
    }

    public int getSxvalue() {
        return sxvalue;
    }

    public void setSxvalue(int sxvalue) {
        this.sxvalue = sxvalue;
    }

    public LBObject(String sxkey, int sxvalue) {
        this.sxkey = sxkey;
        this.sxvalue = sxvalue;
    }

    public LBObject() {
    }

    @Override
    public String toString() {
        return "LBObject{" +
                "sxkey='" + sxkey + '\'' +
                ", sxvalue=" + sxvalue +
                '}';
    }
}

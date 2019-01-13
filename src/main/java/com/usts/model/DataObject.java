package com.usts.model;

/**@author pizhou
 * 数据模型类, 按照表的结构，所有的操作都应该参考id属性进行
 */
public class DataObject implements Comparable<DataObject>{
    private int id; //  数据编号
    private String cyd_bh; // 采样点编号
    private String cydw; // 采样点位
    private String riqi; // 日期
    private String sxkey; // 属性名
    private double sxvalue; // 属性值
    private int lb; // 属性类别
    private int status = 1; // 状态码

    public DataObject() {
    }

    // 回溯功能对象
    public DataObject(int id, String cyd_bh, String cydw, String riqi, String sxkey, double sxvalue, int lb, int status) {
        this.id = id;
        this.cyd_bh = cyd_bh;
        this.cydw = cydw;
        this.riqi = riqi;
        this.sxkey = sxkey;
        this.sxvalue = sxvalue;
        this.lb = lb;
        this.status = status;
    }

    public DataObject(String cyd_bh, String cydw, String riqi, String sxkey, int lb) {
        this.cyd_bh = cyd_bh;
        this.cydw = cydw;
        this.riqi = riqi;
        this.sxkey = sxkey;
        this.lb = lb;
    }

    // 查找，修改，删除功能对象
    public DataObject(int id, String cyd_bh, String cydw, String riqi, String sxkey, double sxvalue, int lb) {
        this.id = id;
        this.cyd_bh = cyd_bh;
        this.cydw = cydw;
        this.riqi = riqi;
        this.sxkey = sxkey;
        this.sxvalue = sxvalue;
        this.lb = lb;
    }

    // 删除功能对象
    public DataObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCyd_bh() {
        return cyd_bh;
    }

    public void setCyd_bh(String cyd_bh) {
        this.cyd_bh = cyd_bh;
    }

    public String getCydw() {
        return cydw;
    }

    public void setCydw(String cydw) {
        this.cydw = cydw;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public String getSxkey() {
        return sxkey;
    }

    public void setSxkey(String sxkey) {
        this.sxkey = sxkey;
    }

    public double getSxvalue() {
        return sxvalue;
    }

    public void setSxvalue(double sxvalue) {
        this.sxvalue = sxvalue;
    }

    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "==================================DataObject{" +
                "id=" + id +
                ", cyd_bh='" + cyd_bh + '\'' +
                ", cydw='" + cydw + '\'' +
                ", riqi='" + riqi + '\'' +
                ", sxkey='" + sxkey + '\'' +
                ", sxvalue=" + sxvalue +
                ", lb=" + lb +
                ", status=" + status +
                '}';
    }

    @Override
    public int compareTo(DataObject o) {
        return this.getRiqi().compareTo(o.getRiqi());
    }
}

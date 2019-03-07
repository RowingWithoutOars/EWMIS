package com.usts.model;

public class ZBObject {
    private String point1;
    private String point2;
    private String address;

    public ZBObject(){

    }

    public ZBObject(String point1, String point2, String address) {
        this.point1 = point1;
        this.point2 = point2;
        this.address = address;
    }

    public String getPoint1() {
        return point1;
    }

    public void setPoint1(String point1) {
        this.point1 = point1;
    }

    public String getPoint2() {
        return point2;
    }

    public void setPoint2(String point2) {
        this.point2 = point2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ZBObject{" +
                "point1='" + point1 + '\'' +
                ", point2='" + point2 + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

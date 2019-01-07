package com.usts.model;

public class Users {
    private int userid;
    private String username;
    private String userpw;
    private String lb;

    public Users() {
    }

    public Users(int userid) {
        this.userid = userid;
    }

    public Users(String username, String userpw) {
        this.username = username;
        this.userpw = userpw;
    }

    public Users(String username, String userpw,String lb) {
        this.lb = lb;
        this.username = username;
        this.userpw = userpw;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpw() {
        return userpw;
    }

    public void setUserpw(String userpw) {
        this.userpw = userpw;
    }

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpw='" + userpw + '\'' +
                ", lb='" + lb + '\'' +
                '}';
    }
}

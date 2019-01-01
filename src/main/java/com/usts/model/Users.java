package com.usts.model;

public class Users {
    private int userid;
    private String username;
    private String userpw;

    public Users() {
    }

    public Users(int userid) {
        this.userid = userid;
    }

    public Users(String username, String userpw) {
        this.username = username;
        this.userpw = userpw;
    }

    public Users(int userid, String username, String userpw) {
        this.userid = userid;
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

    @Override
    public String toString() {
        return "==================================Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpw='" + userpw + '\'' +
                '}';
    }
}

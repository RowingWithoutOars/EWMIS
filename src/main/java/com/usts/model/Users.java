package com.usts.model;

import com.usts.tools.Auth;

import java.util.ArrayList;
import java.util.HashSet;
public class Users {
    private int userid;
    private String username;
    private String userpw;
    private int fydw;
    private int fyzw;
    private int dq;
    private int wsw;
    private int dn;
    private int other;
    private static ArrayList<Integer> auth = new ArrayList<>();

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

    public int getFydw() {
        return fydw;
    }

    public void setFydw(int fydw) {
        this.fydw = fydw;
    }

    public int getFyzw() {
        return fyzw;
    }

    public void setFyzw(int fyzw) {
        this.fyzw = fyzw;
    }

    public int getDq() {
        return dq;
    }

    public void setDq(int dq) {
        this.dq = dq;
    }

    public int getWsw() {
        return wsw;
    }

    public void setWsw(int wsw) {
        this.wsw = wsw;
    }

    public int getDn() {
        return dn;
    }

    public void setDn(int dn) {
        this.dn = dn;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public ArrayList<Integer> getAuth() {
        addAuth();
        return auth;
    }

    public Users() {
    }

    public Users(int userid, String username, String userpw, int fydw, int fyzw, int dq, int wsw, int dn, int other) {
        this.userid = userid;
        this.username = username;
        this.userpw = userpw;
        this.fydw = fydw;
        this.fyzw = fyzw;
        this.dq = dq;
        this.wsw = wsw;
        this.dn = dn;
        this.other = other;
    }

    public Users(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userpw='" + userpw + '\'' +
                ", fydw=" + fydw +
                ", fyzw=" + fyzw +
                ", dq=" + dq +
                ", wsw=" + wsw +
                ", dn=" + dn +
                ", other=" + other +
                '}';
    }

    public Users(String username, String userpw) {
        this.username = username;
        this.userpw = userpw;
    }

    private void addAuth(){
        if (getFydw()>0){
            auth.addAll(Auth.getAuth().get("fydw"));
        }
        if (getFyzw()>0){
            auth.addAll(Auth.getAuth().get("fyzw"));
        }
        if (getDn()>0){
            auth.addAll(Auth.getAuth().get("dn"));
        }
        if (getDq()>0){
            auth.addAll(Auth.getAuth().get("dq"));
        }
        if (getWsw()>0){
            auth.addAll(Auth.getAuth().get("wsw"));
        }
        if (getOther()>0){
            auth.addAll(Auth.getAuth().get("other"));
        }
        removeDuplicate();
    }

    private static void removeDuplicate(){
        HashSet h = new HashSet(auth);
        auth.clear();
        auth.addAll(h);
    }
}

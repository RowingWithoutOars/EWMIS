package com.usts.model;

import com.usts.tools.Auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class Users {
    private int userid;
    private String username;
    private String userpw = null;
    private int fydw = -1;
    private int fyzw = -1;
    private int dq = -1;
    private int wsw = -1;
    private int dn = -1;
    private int other = -1;
    private String phone = null;
    private ArrayList<Integer> auth = new ArrayList<>();
    private HashMap<String,Integer> roleAuth= new HashMap();

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Integer> getAuth() {
        addAuth();
        return auth;
    }

    public HashMap<String, Integer> getRoleAuth() {
        addRoleAuth();
        return roleAuth;
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
        auth = new ArrayList<>();
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
        removeDuplicate(auth);
    }

    private void addRoleAuth(){
        roleAuth.put("fydw",getFydw());
        roleAuth.put("fyzw",getFyzw());
        roleAuth.put("dn",getDn());
        roleAuth.put("dq",getDq());
        roleAuth.put("wsw",getWsw());
        roleAuth.put("other",getOther());
    }

    private static void removeDuplicate(ArrayList auth){
        HashSet h = new HashSet(auth);
        auth.clear();
        auth.addAll(h);
    }
}

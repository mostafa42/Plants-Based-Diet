package com.example.asus.pbd_project2.Classes;

/**
 * Created by Mostafa on 29/05/2019.
 */

public class Users {

    String uid , fname , uname , phone ,  pass , utype , loc ;

    public Users() {
    }

    public Users(String uid, String fname, String uname, String phone, String pass, String utype, String loc) {
        this.uid = uid;
        this.fname = fname;
        this.uname = uname;
        this.phone = phone;
        this.pass = pass;
        this.utype = utype;
        this.loc = loc;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}

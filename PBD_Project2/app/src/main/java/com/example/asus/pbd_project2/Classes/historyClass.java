package com.example.asus.pbd_project2.Classes;

/**
 * Created by Mostafa on 04/06/2019.
 */

public class historyClass {

    String actionid , uid , action , time , data ;

    public historyClass() {
    }

    public historyClass(String actionid, String uid, String action, String time, String data) {
        this.actionid = actionid;
        this.uid = uid;
        this.action = action;
        this.time = time;
        this.data = data;
    }

    public String getActionid() {
        return actionid;
    }

    public void setActionid(String actionid) {
        this.actionid = actionid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

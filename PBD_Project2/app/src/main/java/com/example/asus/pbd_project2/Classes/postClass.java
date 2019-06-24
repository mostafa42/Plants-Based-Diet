package com.example.asus.pbd_project2.Classes;

/**
 * Created by Mostafa on 12/04/2019.
 */

public class postClass {
    String id , uid , color , post , uname ;

    public postClass() {
    }

    public postClass(String id, String uid, String color, String post, String uname) {
        this.id = id;
        this.uid = uid;
        this.color = color;
        this.post = post;
        this.uname = uname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}

package com.example.asus.pbd_project2.Classes;

/**
 * Created by Mostafa on 13/04/2019.
 */

public class commentClass {

    String commentid , postid , userid , username , comment ;

    public commentClass() {
    }

    public commentClass(String commentid, String postid, String userid, String username, String comment) {
        this.commentid = commentid;
        this.postid = postid;
        this.userid = userid;
        this.username = username;
        this.comment = comment;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

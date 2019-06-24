package com.example.asus.pbd_project2.Classes;

/**
 * Created by Mostafa on 27/05/2019.
 */

public class upload {

    private String imgName , imgUrl ;

    public upload() {
    }


    public upload(String imgName, String imgUrl) {
        if(imgName.trim().equals("")){
            imgName = "No Name" ;
        }
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

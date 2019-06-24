package com.example.asus.pbd_project2.UPloadImage1;

import com.google.firebase.database.Exclude;

/**
 * Created by ASUS on 28/05/2019.
 */

public class Upload {
    public String name;
    public String url;
    private String mKey;
    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public Upload() {
    }

    public Upload(String name, String url) {
        this.name = name;
        this.url= url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}

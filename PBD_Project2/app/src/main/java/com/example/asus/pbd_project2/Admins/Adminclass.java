package com.example.asus.pbd_project2.Admins;

/**
 * Created by ASUS on 01/04/2019.
 */

public class Adminclass {
    String key;

    String name;
    String location;
    String pass ;
    int age;

    public Adminclass(String key, String name, int age , String pass  , String location) {
        this.key = key;
        this.name = name;
      this.pass=pass;
        this.location = location;

        this.age = age;
    }

    public Adminclass() {
    }



    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }


    public String getLocation() {
        return location;
    }

    public int getAge() {
        return age;
    }
}

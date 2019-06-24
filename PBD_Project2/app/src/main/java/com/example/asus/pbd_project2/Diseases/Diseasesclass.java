package com.example.asus.pbd_project2.Diseases;

/**
 * Created by ASUS on 01/04/2019.
 */

public class Diseasesclass {
    String key;

    String name;
    String location;
    //int age;

    public Diseasesclass(String key, String name , String location) {
        this.key = key;
        this.name = name;
        this.location = location;

        //this.age = age;
    }

    public Diseasesclass() {
    }



    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    //public int getAge() {
   //     return age;
   // }

}

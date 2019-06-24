package com.example.asus.pbd_project2.Clinic;

/**
 * Created by ASUS on 01/04/2019.
 */

public class Clinicclass {
    String key;

    String name;
    String location;
    String location2;
    String Address ;
    //int age;

    public Clinicclass(String key, String name , String location ,String location2) {
        this.key = key;
        this.name = name;
        this.location = location;
        this.location2 = location2;
        //this.age = age;
    }

    public Clinicclass() {
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
    public String getLocation2() {
        return location2;
    }
    //public int getAge() {
   //     return age;
   // }

}

package com.example.asus.pbd_project2.Restaurant;

/**
 * Created by ASUS on 08/03/2019.
 */

public class RestaurantData {

    String key;

    String name;
    String location;
    int age;

    public RestaurantData(String key, String name, int age , String location) {
        this.key = key;
        this.name = name;
        this.location = location;

        this.age = age;
    }

    public RestaurantData() {
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

    public int getAge() {
        return age;
    }

}

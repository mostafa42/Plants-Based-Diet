package com.example.asus.pbd_project2.Ingrediant;

/**
 * Created by ASUS on 30/03/2019.
 */

public class IngrediantClass {


    String key;

    String name;
    int age;

    public IngrediantClass(String key, String name, int age) {
        this.key = key;
        this.name = name;

        this.age = age;
    }

    public IngrediantClass() {
    }



    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }



    public int getAge() {
        return age;
    }
}
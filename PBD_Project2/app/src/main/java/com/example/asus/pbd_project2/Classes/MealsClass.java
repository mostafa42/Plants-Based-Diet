package com.example.asus.pbd_project2.Classes;

/**
 * Created by Mostafa on 08/06/2019.
 */

public class MealsClass {

    String compn1  , compn2 , compn3 , compn4 ,compn5 , compn6 , total ;

    public MealsClass() {
    }

    public MealsClass(String compn1, String compn2, String compn3, String compn4, String compn5, String compn6, String total) {
        this.compn1 = compn1;
        this.compn2 = compn2;
        this.compn3 = compn3;
        this.compn4 = compn4;
        this.compn5 = compn5;
        this.compn6 = compn6;
        this.total = total;
    }

    public String getCompn1() {
        return compn1;
    }

    public void setCompn1(String compn1) {
        this.compn1 = compn1;
    }

    public String getCompn2() {
        return compn2;
    }

    public void setCompn2(String compn2) {
        this.compn2 = compn2;
    }

    public String getCompn3() {
        return compn3;
    }

    public void setCompn3(String compn3) {
        this.compn3 = compn3;
    }

    public String getCompn4() {
        return compn4;
    }

    public void setCompn4(String compn4) {
        this.compn4 = compn4;
    }

    public String getCompn5() {
        return compn5;
    }

    public void setCompn5(String compn5) {
        this.compn5 = compn5;
    }

    public String getCompn6() {
        return compn6;
    }

    public void setCompn6(String compn6) {
        this.compn6 = compn6;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

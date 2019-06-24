package com.example.asus.pbd_project2.Classes;

/**
 * Created by Mostafa on 21/04/2019.
 */

public class coloriesClass {

    String cid , classification , cname , coloriesvalue ;

    public coloriesClass() {
    }

    public coloriesClass(String cid, String classification, String cname, String coloriesvalue) {
        this.cid = cid;
        this.classification = classification;
        this.cname = cname;
        this.coloriesvalue = coloriesvalue;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
    

    public void setColoriesvalue(String coloriesvalue) {
        this.coloriesvalue = coloriesvalue;
    }

    public String getColoriesvalue() {
        return coloriesvalue;
    }
}

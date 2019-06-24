package com.example.asus.pbd_project2.Classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Mostafa on 04/06/2019.
 */

public class GettingTimeAndDate {

    public GettingTimeAndDate() {
    }

    // Get Time
    public  String GetTime (){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String Time = format.format(calendar.getTime());
        return Time;
    }
    // Get Date
    public String GetDate (){
        Calendar calendar = Calendar.getInstance();
        String CurrentDate = DateFormat.getDateInstance().format(calendar.getTime());
        return CurrentDate;
    }
}

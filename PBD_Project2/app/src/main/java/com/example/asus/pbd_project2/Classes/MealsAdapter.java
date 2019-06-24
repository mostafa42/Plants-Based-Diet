package com.example.asus.pbd_project2.Classes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.MealsClass;
import com.example.asus.pbd_project2.R;

import java.util.ArrayList;

/**
 * Created by Mostafa on 08/06/2019.
 */

public class MealsAdapter extends ArrayAdapter<MealsClass> {

    Context context;
    MealsClass mealClassObject ;

    public MealsAdapter(Context context, ArrayList<MealsClass> meal) {
        super(context, 0, meal);
        this.context = context;
        mealClassObject = new MealsClass();
    }
    
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Get the data item for this position
            mealClassObject = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_meals, parent, false);
            }

            // Variables Section
            TextView txt1 , txt2 , txt3 , txt4 , txt5 ,txt6 , total ;

            // Define The Components Section
            txt1 = convertView.findViewById(R.id.comp1);
            txt2 = convertView.findViewById(R.id.comp2);
            txt3 = convertView.findViewById(R.id.comp3);
            txt4 = convertView.findViewById(R.id.comp4);
            txt5 = convertView.findViewById(R.id.comp5);
            txt6 = convertView.findViewById(R.id.comp6);
            total = convertView.findViewById(R.id.total);

            // But Data From DB
            txt1.setText(mealClassObject.getCompn1());
            txt2.setText(mealClassObject.getCompn2());
            txt3.setText(mealClassObject.getCompn3());
            txt4.setText(mealClassObject.getCompn4());
            txt5.setText(mealClassObject.getCompn5());
            txt6.setText(mealClassObject.getCompn6());

            total.setText(mealClassObject.getTotal());



    }catch (Exception ex){
            Toast.makeText(context, ""+ex, Toast.LENGTH_SHORT).show();
        }
        return convertView;
    }



}

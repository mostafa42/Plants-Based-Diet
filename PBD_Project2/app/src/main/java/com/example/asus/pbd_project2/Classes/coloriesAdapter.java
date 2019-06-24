package com.example.asus.pbd_project2.Classes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.coloriesClass;
import com.example.asus.pbd_project2.R;


import java.util.ArrayList;

/**
 * Created by Mostafa on 25/04/2019.
 */

public class coloriesAdapter extends ArrayAdapter<coloriesClass> {

    Context context;

    public coloriesAdapter(Context context, ArrayList<coloriesClass> colories) {
        super(context, 0, colories);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Get the data item for this position
            final coloriesClass coloriesClassObject = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_product_colories, parent, false);
            }

            // Variables Section
            TextView type , name , values ;

            // Define The Components Section
            type = (TextView) convertView.findViewById(R.id.product_type);

            name = (TextView) convertView.findViewById(R.id.product_name);

            values = (TextView) convertView.findViewById(R.id.product_colories);

            // Set Getting Values In Last TextViews Which Defined

            type.setText(coloriesClassObject.getClassification());
            name.setText(coloriesClassObject.getCname());
            values.setText(coloriesClassObject.getColoriesvalue());


        }catch (Exception ex){
            Toast.makeText(context, "In Adapter "+ex, Toast.LENGTH_SHORT).show();
        }
        return convertView;
    }

}

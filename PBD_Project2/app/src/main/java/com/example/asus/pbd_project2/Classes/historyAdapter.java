package com.example.asus.pbd_project2.Classes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.asus.pbd_project2.Classes.historyClass;
import com.example.asus.pbd_project2.R;

import java.util.ArrayList;

/**
 * Created by Mostafa on 04/06/2019.
 */

public class historyAdapter  extends ArrayAdapter<historyClass> {

    Context context;

    public historyAdapter(Context context, ArrayList<historyClass> history) {
        super(context, 0, history);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Get the data item for this position
            final historyClass historyClassObject = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_history, parent, false);
            }

            // Variables Section
            TextView action , time , date ;

            // Define The Components Section
            action = (TextView) convertView.findViewById(R.id.action);
            time = (TextView) convertView.findViewById(R.id.timeValue);
            date = (TextView) convertView.findViewById(R.id.dateValue);


            // But Values Which Come From Data
            action.setText(historyClassObject.getAction());
            time.setText(historyClassObject.getTime());
            date.setText(historyClassObject.getData());



        }catch (Exception ex){
            Toast.makeText(context, "In Adapter Of History "+ex, Toast.LENGTH_SHORT).show();
        }
        return convertView;
    }
}

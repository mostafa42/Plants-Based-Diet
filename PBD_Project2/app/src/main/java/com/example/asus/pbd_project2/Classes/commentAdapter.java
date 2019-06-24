package com.example.asus.pbd_project2.Classes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.commentClass;
import com.example.asus.pbd_project2.R;

import java.util.ArrayList;

/**
 * Created by Mostafa on 13/04/2019.
 */

public class commentAdapter extends ArrayAdapter<commentClass> {

    Context context;

    public commentAdapter(Context context, ArrayList<commentClass> comment) {
        super(context, 0, comment);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Get the data item for this position
            final commentClass commentClassObject = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_comment, parent, false);
            }

            // Variables Section
            TextView name_of_user , comment_summary ;

            // Define The Components Section
            name_of_user = convertView.findViewById(R.id.commenter_name);
            comment_summary = convertView.findViewById(R.id.comment_getting);

            name_of_user.setText(commentClassObject.getUsername());
            comment_summary.setText(commentClassObject.getComment());



    }catch (Exception ex){
            Toast.makeText(context, "In Adapter "+ex, Toast.LENGTH_SHORT).show();
        }
        return convertView;
    }
}

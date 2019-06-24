package com.example.asus.pbd_project2.Classes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Clinic.Clinicclass;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.Visitor.GetCloseClinicActivity;
import com.example.asus.pbd_project2.Visitor.Posts.showPostsActivity;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by ASUS on 15/06/2019.
 */

public class Clinics2Adapter extends ArrayAdapter<Clinicclass> {

    Context context;
    String NameOfCommenter;
    String comment_id, CommentText;
    DatabaseReference reference;
    GetCloseClinicActivity object;

    public Clinics2Adapter(Context context, ArrayList<Clinicclass> clinic) {
        super(context, 0, clinic);
        this.context = context;
        object = new GetCloseClinicActivity();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Get the data item for this position
            final Clinicclass clinicClassObject = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_close_clinic, parent, false);
            }

            // Variables Section
            TextView ValueOfClinic ;

            // Define The Components Section
           ValueOfClinic = (TextView) convertView.findViewById(R.id.nearestclinic);

            // Set The Value
            ValueOfClinic.setText(clinicClassObject.getLocation());


        } catch (Exception ex) {
            Toast.makeText(context, "Clinic Adapter 2 " + ex, Toast.LENGTH_LONG).show();
        }
        return convertView;

    }
}

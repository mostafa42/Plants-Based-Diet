package com.example.asus.pbd_project2.Clinic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.pbd_project2.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 01/04/2019.
 */

public class ClinicApter extends BaseAdapter {

    TextView name, location , location2;

    Context context;

    ArrayList<Clinicclass> data;

    LayoutInflater inflater;

    public ClinicApter(Context context, ArrayList<Clinicclass> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.from(context).inflate(R.layout.clinic_list,viewGroup,false);

        name = (TextView) view.findViewById(R.id.readname);
        //age = (TextView) view.findViewById(R.id.readage);
        location = (TextView) view.findViewById(R.id.readlocation);
        location2 = (TextView) view.findViewById(R.id.readlocation2);
        name.setText(name.getText()+data.get(i).getName());
        location.setText(location.getText()+data.get(i).getLocation());
        location2.setText(location2.getText()+data.get(i).getLocation2());
        //age.setText(age.getText()+""+ data.get(i).getAge());



        return view;
    }
}

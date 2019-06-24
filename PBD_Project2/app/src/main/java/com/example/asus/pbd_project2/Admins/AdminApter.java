package com.example.asus.pbd_project2.Admins;

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

public class AdminApter extends BaseAdapter {
    TextView name, age, location , pass;

    Context context;

    ArrayList<Adminclass> data;

    LayoutInflater inflater;

    public AdminApter(Context context, ArrayList<Adminclass> data) {
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

        view = inflater.from(context).inflate(R.layout.admin_list, viewGroup, false);

        name = (TextView) view.findViewById(R.id.readname);
        pass = (TextView) view.findViewById(R.id.readpass);
        age = (TextView) view.findViewById(R.id.readage);
        location = (TextView) view.findViewById(R.id.readlocation);

        name.setText(name.getText() + data.get(i).getName());
        pass.setText(pass.getText() + data.get(i).getPass());

        location.setText(location.getText() + data.get(i).getLocation());
        age.setText(age.getText() + "" + data.get(i).getAge());


        return view;
    }
}
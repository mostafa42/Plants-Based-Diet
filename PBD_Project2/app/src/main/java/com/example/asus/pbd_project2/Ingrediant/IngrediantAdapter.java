package com.example.asus.pbd_project2.Ingrediant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.pbd_project2.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 30/03/2019.
 */

public class IngrediantAdapter extends BaseAdapter {


    TextView name, age;

    Context context;

    ArrayList<IngrediantClass> data;

    LayoutInflater inflater;

    public IngrediantAdapter(Context context, ArrayList<IngrediantClass> data) {
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

        view = inflater.from(context).inflate(R.layout.ingraident_list,viewGroup,false);

        name = (TextView) view.findViewById(R.id.readname);
        age = (TextView) view.findViewById(R.id.readage);


        name.setText(name.getText()+data.get(i).getName());
        age.setText(age.getText()+""+ data.get(i).getAge());



        return view;
    }
}
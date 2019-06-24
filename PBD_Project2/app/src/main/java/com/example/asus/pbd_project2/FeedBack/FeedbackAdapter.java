package com.example.asus.pbd_project2.FeedBack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.asus.pbd_project2.R;

import java.util.ArrayList;

/**
 * Created by ASUS on 08/04/2019.
 */

public class FeedbackAdapter extends BaseAdapter {


    TextView name, age;

    Context context;

    ArrayList<Feedbackclass> data;

    LayoutInflater inflater;

    public FeedbackAdapter(Context context, ArrayList<Feedbackclass> data) {
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

        view = inflater.from(context).inflate(R.layout.feedback_list,viewGroup,false);

        name = (TextView) view.findViewById(R.id.readname);
//        age = (TextView) view.findViewById(R.id.readage);


        name.setText(name.getText()+data.get(i).getName());
       // age.setText(age.getText()+""+ data.get(i).getAge());



        return view;
    }
}
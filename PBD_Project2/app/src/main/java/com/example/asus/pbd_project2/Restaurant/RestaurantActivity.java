package com.example.asus.pbd_project2.Restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.asus.pbd_project2.Admins.AdminsActivity;
import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {
    LayoutInflater inflater1;

    int count =0;
    int age;
    String name;
    String location;
    String ResNum ;
    EditText txtname,txtlocattion, txtage,txtsearch;

    private TextView textViewShow;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    RestaurantData data;


    ListView listView;

    ArrayList<RestaurantData> dataArrayList;

    RestaurantApter  customAdapter;

    String key;

    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("restaurants");
        key=databaseReference.push().getKey();

        txtname = (EditText) findViewById(R.id.writename);
        txtlocattion= (EditText) findViewById(R.id.writelocation);
        txtage = (EditText)findViewById(R.id.writeage);
        textViewShow = (TextView) findViewById(R.id.text_view_show);



        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    name = txtname.getText().toString().trim();
                    location = txtlocattion.getText().toString().trim();
                    ResNum = txtage.getText().toString().trim();
                    age = Integer.parseInt(txtage.getText().toString().trim());
                    if(name.equals("") || name.equals(" ") || location.equals("") || location.equals(" ") || ResNum.equals("") || ResNum.equals(" ")){
                        Toast.makeText(RestaurantActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                    }else if(age < 0){
                        Toast.makeText(RestaurantActivity.this, "Please Insert Valid Colories", Toast.LENGTH_SHORT).show();
                    }else {
                        data = new RestaurantData(databaseReference.push().getKey(), name, age , location);

                        databaseReference.child(data.getKey()).setValue(data);

                        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();

                        txtname.setText("");
                        txtage.setText("");
                        txtlocattion.setText("");
                    }
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();

                }


            }
        });

 textViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });
    }



    private void openImagesActivity() {
        Intent intent = new Intent(this, RestaurantListActivity.class);
        startActivity(intent);
    }

    public void Logout (View view){
        Intent intent = new Intent(RestaurantActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}















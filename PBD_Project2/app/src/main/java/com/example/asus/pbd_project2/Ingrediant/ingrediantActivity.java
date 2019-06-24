package com.example.asus.pbd_project2.Ingrediant;

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

public class ingrediantActivity extends AppCompatActivity {
    LayoutInflater inflater1;

    int count =0;
    int age;
    String name , col;

    EditText txtname, txtage,txtsearch;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    IngrediantClass data;


    ListView listView;

    ArrayList<IngrediantClass> dataArrayList;

    IngrediantAdapter ingrediantAdapter;
    private TextView textViewShow;

    String key;

    int temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingrediant);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("ingrediants");
        key=databaseReference.push().getKey();

        txtname = (EditText) findViewById(R.id.writename);
        txtage = (EditText)findViewById(R.id.writeage);
        textViewShow = (TextView) findViewById(R.id.text_view_show);


        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    name = txtname.getText().toString().trim();
                    col = txtage.getText().toString().trim();
                    age = Integer.parseInt(txtage.getText().toString().trim());

                    if ( name.equals("") || name.equals(" ") || col.equals("") || col.equals(" ") ) {

                        Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_SHORT).show();

                    }else if(age < 0){

                        Toast.makeText(ingrediantActivity.this, "please insert Valid Colories", Toast.LENGTH_SHORT).show();

                    } else {


                        data = new IngrediantClass(databaseReference.push().getKey(), name, age);

                        databaseReference.child(data.getKey()).setValue(data);

                        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();

                        txtname.setText("");
                        txtage.setText("");

                    }
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();

                }


            }
        });

        dataArrayList = new ArrayList<>();

        ingrediantAdapter = new IngrediantAdapter(ingrediantActivity.this, dataArrayList);
        textViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });
    }



    private void openImagesActivity() {
        Intent intent = new Intent(this, IngrediantListActivity.class);
        startActivity(intent);
    }

    public void Logout (View view){
        Intent intent = new Intent(ingrediantActivity.this , LoginActivity.class);
        startActivity(intent);
    }
}



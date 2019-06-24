package com.example.asus.pbd_project2.Diseases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Admins.AdminsActivity;
import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class DiseasesActivity extends AppCompatActivity {
    LayoutInflater inflater1;

    int count =0;
    //int age;
    String name;
    String location;
    EditText txtname,txtlocattion,txtsearch;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    Diseasesclass data;
    private TextView textViewShow;

   // ListView listView;

    ArrayList<Diseasesclass> dataArrayList;
    DiseasesApter diseasesApter ;
    //  CustomApter  customAdapter;

    String key;
    int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Diseases");
        key=databaseReference.push().getKey();

        txtname = (EditText) findViewById(R.id.writename);
        txtlocattion= (EditText) findViewById(R.id.writelocation);
        textViewShow = (TextView) findViewById(R.id.text_view_show);
        // txtage = (EditText)findViewById(R.id.writeage);
     //   listView = (ListView) findViewById(R.id.readlist);


        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                        name = txtname.getText().toString().trim();
                        location = txtlocattion.getText().toString().trim();

                    if(name.equals("") || name.equals(" ") || location.equals("") || location.equals(" ")){
                        Toast.makeText(DiseasesActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                    }else {
                        data = new Diseasesclass(databaseReference.push().getKey(), name , location);
                        databaseReference.child(data.getKey()).setValue(data);
                        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();
                        txtname.setText("");
                        txtlocattion.setText("");
                    }



                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();

                }


            }
        });

        dataArrayList = new ArrayList<>();

        diseasesApter = new DiseasesApter(DiseasesActivity.this, dataArrayList);

        //listView.setAdapter(diseasesApter);

        textViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });
    }



    private void openImagesActivity() {
        Intent intent = new Intent(this, DiseasesListActivity.class);
        startActivity(intent);
    }

    public void Logout (View view){
        Intent intent = new Intent(DiseasesActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}

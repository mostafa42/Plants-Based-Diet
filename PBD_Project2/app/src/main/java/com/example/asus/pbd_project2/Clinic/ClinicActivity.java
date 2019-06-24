package com.example.asus.pbd_project2.Clinic;

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

public class ClinicActivity extends AppCompatActivity {
    LayoutInflater inflater1;


    int count =0;
    //int age;
    String name;
    String location;
    String location2;
    EditText txtname,txtlocattion,txtlocattion2,txtsearch , txtAddress;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    Clinicclass data;
    private TextView textViewShow;

    ListView listView;

    ArrayList<Clinicclass> dataArrayList;
    ClinicApter clinicApter ;
    //  CustomApter  customAdapter;

    String key;
    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("Clinics");
        key=databaseReference.push().getKey();

        txtname = (EditText) findViewById(R.id.writename);
        txtlocattion= (EditText) findViewById(R.id.writelocation);
        txtlocattion2= (EditText) findViewById(R.id.writelocation2);
        // txtage = (EditText)findViewById(R.id.writeage);
       // listView = (ListView) findViewById(R.id.readlist);
        textViewShow = (TextView) findViewById(R.id.text_view_show);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    name = txtname.getText().toString().trim();
                    // age = Integer.parseInt(txtage.getText().toString().trim());
                    location = txtlocattion.getText().toString().trim();
                    location2 = txtlocattion2.getText().toString().trim();


                    if(name.equals("") || name.equals(" ") || location.equals("") || location.equals(" ")){
                        Toast.makeText(ClinicActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                    }else {
                        data = new Clinicclass(databaseReference.push().getKey(), name , location ,location2);

                        databaseReference.child(data.getKey()).setValue(data);

                        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();

                        txtname.setText("");
                        txtlocattion.setText("");
                        txtlocattion2.setText("");

                    }





                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();

                }


            }
        });

        dataArrayList = new ArrayList<>();

        clinicApter = new ClinicApter(ClinicActivity.this, dataArrayList);



        textViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });
    }



    private void openImagesActivity() {
        Intent intent = new Intent(this, ClinicListActivity .class);
        startActivity(intent);
    }

    public void Logout (View view){
        Intent intent = new Intent(ClinicActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}




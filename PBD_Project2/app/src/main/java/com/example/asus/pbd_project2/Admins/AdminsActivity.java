package com.example.asus.pbd_project2.Admins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.Products.AddProductssActivity;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdminsActivity extends AppCompatActivity {
    LayoutInflater inflater1;

    int count =0;
    int age;
    String name;
    String location;
    String pass ;
    private TextView textViewShow;
    EditText txtname,txtpass ,txtlocattion, txtage,txtsearch;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    Adminclass data;


   // ListView listView;

    ArrayList<Adminclass> dataArrayList;

    AdminApter adminApter;

    String key;

    int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admins);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("admins");
        key=databaseReference.push().getKey();

        txtname = (EditText) findViewById(R.id.writename);
        txtlocattion= (EditText) findViewById(R.id.writelocation);
        txtpass = (EditText) findViewById(R.id.writepass);
        txtage = (EditText)findViewById(R.id.writeage);
        // listView = (ListView) findViewById(R.id.readlist);
        textViewShow = (TextView) findViewById(R.id.text_view_show);




        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {


                        name = txtname.getText().toString().trim(); //
                        location = txtlocattion.getText().toString().trim(); //

                        pass = txtpass.getText().toString().trim();

                        if(name.equals("") || name.equals(" ") || txtage.getText().equals("") || txtage.getText().equals(" ") || location.equals("") || location.equals(" ") || pass.equals("") || pass.equals(" ")) {

                            age = Integer.parseInt(txtage.getText().toString().trim()); //
                            data = new Adminclass(databaseReference.push().getKey(), name, age, location, pass);

                            databaseReference.child(data.getKey()).setValue(data);

                            Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();

                            txtname.setText("");
                            txtage.setText("");
                            txtlocattion.setText("");
                            txtpass.setText("");

                        }


                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();

                }


            }
        });

        dataArrayList = new ArrayList<>();

        adminApter = new AdminApter(AdminsActivity.this, dataArrayList);

        textViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });
    }



    private void openImagesActivity() {
        Intent intent = new Intent(this, AdminListActivity.class);
        startActivity(intent);
    }

    public void Logout (View view){
        Intent intent = new Intent(AdminsActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}





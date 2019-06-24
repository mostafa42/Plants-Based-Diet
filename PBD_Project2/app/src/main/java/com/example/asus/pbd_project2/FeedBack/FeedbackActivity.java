package com.example.asus.pbd_project2.FeedBack;

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

public class FeedbackActivity extends AppCompatActivity {
    LayoutInflater inflater1;

    int count =0;

    String name;

    EditText txtname,txtsearch;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    Feedbackclass data;
    private TextView textViewShow;

    //ListView listView;

    ArrayList<Feedbackclass> dataArrayList;

    FeedbackAdapter feedbackAdapter;

    String key;

    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Feedbacks");

        key=databaseReference.push().getKey();

        txtname = (EditText) findViewById(R.id.writename);
        textViewShow = (TextView) findViewById(R.id.text_view_show);

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    name = txtname.getText().toString().trim();


                    if (name.equals("") || name.equals(" ")) {

                        Toast.makeText(FeedbackActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();

                    }else if(name.length() < 20){
                        Toast.makeText(FeedbackActivity.this, "The Number Of Words Should be Bigger Than Or equals 20", Toast.LENGTH_SHORT).show();
                    } else {

                        data = new Feedbackclass(databaseReference.push().getKey(), name);

                        databaseReference.child(data.getKey()).setValue(data);

                        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();

                        txtname.setText("");
                    }
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();

                }


            }
        });

        dataArrayList = new ArrayList<>();

        feedbackAdapter = new FeedbackAdapter(FeedbackActivity.this, dataArrayList);


        textViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });
    }



    private void openImagesActivity() {
        Intent intent = new Intent(this, UFeedbackListActivity.class);
        startActivity(intent);
    }

    public void Logout (View view){
        Intent intent = new Intent(FeedbackActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}


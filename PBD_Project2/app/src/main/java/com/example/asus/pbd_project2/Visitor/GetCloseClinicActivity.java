package com.example.asus.pbd_project2.Visitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.Clinics2Adapter;
import com.example.asus.pbd_project2.Classes.Users;
import com.example.asus.pbd_project2.Classes.postAdapter;
import com.example.asus.pbd_project2.Classes.postClass;
import com.example.asus.pbd_project2.Clinic.Clinicclass;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.Visitor.Posts.showPostsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GetCloseClinicActivity extends AppCompatActivity {

    ArrayList<Clinicclass> arrayOfClinic ;
    ListView listView;
    Clinics2Adapter adapter ;
    String UserLoc ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_close_clinic);

        // Get Id From Previous Activity
        Intent intent=getIntent();
        UserLoc = intent.getStringExtra("Loc");
        Toast.makeText(this, "ID Recived  ==>  "+UserLoc, Toast.LENGTH_SHORT).show();

        listView = (ListView) findViewById(R.id.clinic_list_done);


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Clinics");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayOfClinic = new ArrayList<Clinicclass>();
                for (DataSnapshot postSnapShat : dataSnapshot.getChildren()){
                    Clinicclass object = postSnapShat.getValue(Clinicclass.class);
                   if(UserLoc.equals(object.getLocation2())){
                      arrayOfClinic.add(object);
                       Toast.makeText(GetCloseClinicActivity.this, object.getLocation2(), Toast.LENGTH_SHORT).show();
                    }
                }

                adapter = new Clinics2Adapter(GetCloseClinicActivity.this, arrayOfClinic);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

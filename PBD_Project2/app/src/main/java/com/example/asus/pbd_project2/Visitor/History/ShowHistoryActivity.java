package com.example.asus.pbd_project2.Visitor.History;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.historyAdapter;
import com.example.asus.pbd_project2.Classes.historyClass;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowHistoryActivity extends AppCompatActivity {


    ArrayList<historyClass> arrayOfHistory ;
    ListView listView;
    historyAdapter adapter ;
    String UserId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);

            // Get Id From Previous Activity
            Intent intent=getIntent();
            UserId = intent.getStringExtra("UID");

        listView = (ListView) findViewById(R.id.history_list);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("History");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayOfHistory = new ArrayList<historyClass>();
                for (DataSnapshot historySnapShat : dataSnapshot.getChildren()) {
                    historyClass object = historySnapShat.getValue(historyClass.class);

                    if (UserId.equals(object.getUid())) {
                        arrayOfHistory.add(object);
                    }
                }

                adapter = new historyAdapter(ShowHistoryActivity.this, arrayOfHistory);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }catch(Exception ex){
        Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
    }
    }
}

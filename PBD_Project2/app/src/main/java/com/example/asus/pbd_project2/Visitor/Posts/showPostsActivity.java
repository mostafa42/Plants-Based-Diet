package com.example.asus.pbd_project2.Visitor.Posts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.GettingTimeAndDate;
import com.example.asus.pbd_project2.Classes.historyClass;
import com.example.asus.pbd_project2.Classes.postAdapter;
import com.example.asus.pbd_project2.Classes.postClass;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showPostsActivity extends AppCompatActivity {


    ArrayList<postClass> arrayOfPosts ;
    ListView listView;
    postAdapter adapter ;
    String UserId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_posts);




            Intent intent=getIntent();
            UserId = intent.getStringExtra("UID");

            listView = (ListView) findViewById(R.id.post_list);



            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Posts");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    arrayOfPosts = new ArrayList<postClass>();
                    for (DataSnapshot postSnapShat : dataSnapshot.getChildren()){
                        postClass object = postSnapShat.getValue(postClass.class);
                        arrayOfPosts.add(object);
                    }

                    adapter = new postAdapter(showPostsActivity.this, arrayOfPosts);
                    listView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            // Send Id To use it in comment
            SharedPreferences sharedPreferences = getSharedPreferences("Data" , MODE_PRIVATE);
            SharedPreferences.Editor editor  = sharedPreferences.edit();
            editor.putString("CommId" , UserId);
            editor.commit();


            // Save History
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("History");
            GettingTimeAndDate gettingTimeAndDate = new GettingTimeAndDate();
            String action_id = databaseReference.push().getKey();
            String uid = UserId;
            String action = "You Seen All Posts" ;
            String date = gettingTimeAndDate.GetDate();
            String time = gettingTimeAndDate.GetTime();
            historyClass object = new historyClass(action_id , uid , action , time , date);
            databaseReference.push().setValue(object);

        }catch (Exception ex){
            Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
        }
    }


}

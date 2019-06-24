package com.example.asus.pbd_project2.Visitor.Posts;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.commentAdapter;
import com.example.asus.pbd_project2.Classes.commentClass;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class showComments extends AppCompatActivity {

    String DEFALUT = "NA" ;
    ArrayList<commentClass> arrayOfComments ;
    ListView listView;
    commentAdapter adapter2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_comments);

            SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
            final String post_id = sharedPreferences.getString("post_ids", DEFALUT);


            listView = (ListView) findViewById(R.id.comment_listview);


            //     post_id.getIntent.getExtras().getString();

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Comments");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                 try {
                     arrayOfComments = new ArrayList<commentClass>();
                     //Toast.makeText(showComments.this, "1", Toast.LENGTH_SHORT).show();

                    for (DataSnapshot commentSnapShat : dataSnapshot.getChildren()) {
                      //  Toast.makeText(showComments.this, "2", Toast.LENGTH_SHORT).show();
                        commentClass commentObject = commentSnapShat.getValue(commentClass.class);
                        //Toast.makeText(showComments.this, "3", Toast.LENGTH_SHORT).show();
                        if (commentObject.getPostid().equals(post_id)) {
                          //  Toast.makeText(showComments.this, "4", Toast.LENGTH_SHORT).show();
                            arrayOfComments.add(commentObject); // Faild
                            // Toast.makeText(showComments.this, "5", Toast.LENGTH_SHORT).show();
                            //Toast.makeText(showComments.this, comment.getComment(), Toast.LENGTH_SHORT).show();
                        }
                        // Toast.makeText(showComments.this, "6", Toast.LENGTH_SHORT).show();
                       adapter2 = new commentAdapter(showComments.this, arrayOfComments);
                        // Toast.makeText(showComments.this, "7", Toast.LENGTH_SHORT).show();
                       listView.setAdapter(adapter2);
                        // Toast.makeText(showComments.this, "8", Toast.LENGTH_SHORT).show();

                    }
                }catch (Exception ex){
                     Toast.makeText(showComments.this, "In Action "+ex, Toast.LENGTH_LONG).show();
                     Toast.makeText(showComments.this, "In Action "+ex, Toast.LENGTH_LONG).show();
                 }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

        }catch (Exception ex){
            Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
        }
    }
}

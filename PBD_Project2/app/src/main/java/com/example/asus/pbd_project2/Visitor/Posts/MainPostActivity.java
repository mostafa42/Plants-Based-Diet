package com.example.asus.pbd_project2.Visitor.Posts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.pbd_project2.Admins.AdminsActivity;
import com.example.asus.pbd_project2.Classes.GettingTimeAndDate;
import com.example.asus.pbd_project2.Classes.Users;
import com.example.asus.pbd_project2.Classes.historyClass;
import com.example.asus.pbd_project2.Classes.postClass;
import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainPostActivity extends AppCompatActivity {

    public String colorSelector ;
    EditText post ;
    Button saveBtn , bluebtn , blackbtn , redbtn , defaultbtn ;
    DatabaseReference reference ;
    String UserId , DEFAULT = "null" , PublisherName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_main);

        // Get Id From Previous Activity
        Intent intent=getIntent();
        UserId = intent.getStringExtra("UID");
        Toast.makeText(this, "ID Recived  ==>  "+UserId, Toast.LENGTH_SHORT).show();




        post = (EditText) findViewById(R.id.post_edit_text);
        blackbtn = (Button) findViewById(R.id.black);
        bluebtn = (Button) findViewById(R.id.blue);
        redbtn = (Button) findViewById(R.id.red);
        defaultbtn = (Button) findViewById(R.id.main_bg);
        saveBtn = (Button) findViewById(R.id.btn_save);

        reference = FirebaseDatabase.getInstance().getReference("Posts");

        colorSelector = "R.drawable.custom_create_post_default" ;

        blackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    post.setBackgroundDrawable(ContextCompat.getDrawable(MainPostActivity.this, R.drawable.custom_create_post_black) );
                    colorSelector = "222";
                } else {
                    post.setBackground(ContextCompat.getDrawable(MainPostActivity.this, R.drawable.custom_create_post_black));
                    colorSelector = "222";
                }
            }
        });
        bluebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    colorSelector = "111";
                    post.setBackgroundDrawable(ContextCompat.getDrawable(MainPostActivity.this, R.color.zety2) );
                } else {
                    colorSelector = "111";
                    post.setBackground(ContextCompat.getDrawable(MainPostActivity.this, R.drawable.custom_create_post_blue));
                }
            }
        });
        redbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    colorSelector = "333";
                    post.setBackgroundDrawable(ContextCompat.getDrawable(MainPostActivity.this, R.drawable.custom_create_post_red) );
                } else {
                    colorSelector = "333";
                    post.setBackground(ContextCompat.getDrawable(MainPostActivity.this, R.drawable.custom_create_post_red));
                }
            }
        });
        try {
            defaultbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final int sdk = android.os.Build.VERSION.SDK_INT;
                    if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        colorSelector = "444";
                        post.setBackgroundDrawable(ContextCompat.getDrawable(MainPostActivity.this, R.color.colorWhite));
                    } else {
                        colorSelector = "444";
                        post.setBackground(ContextCompat.getDrawable(MainPostActivity.this, R.drawable.custom_create_post_default));
                    }
                }
            });
        }catch (Exception ex){
            Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
        }
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    if(post.getText().toString().equals("") || post.getText().toString().equals("")){
                        Toast.makeText(MainPostActivity.this, "please Write Post", Toast.LENGTH_SHORT).show();
                    }else {
                        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Users");
                        reference2.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                    Users user = snapshot.getValue(Users.class);
                                    if( UserId.equals(user.getUid()) ) {
                                        PublisherName = user.getUname();
                                        String PostText = post.getText().toString();
                                        String id = reference.push().getKey();
                                        postClass postObject = new postClass(id, UserId, colorSelector, PostText , PublisherName);
                                        postObject.setColor(colorSelector);
                                        postObject.setId(id);
                                        postObject.setUid(UserId);
                                        postObject.setPost(PostText);
                                        postObject.setUname(PublisherName);
                                        reference.push().setValue(postObject);
                                        Toast.makeText(MainPostActivity.this, "The Post Is Inserted Successfully", Toast.LENGTH_SHORT).show();




                                        break;
                                    }
                                }
                                // Save History
                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("History");
                                GettingTimeAndDate gettingTimeAndDate = new GettingTimeAndDate();
                                String action_id = databaseReference.push().getKey();
                                String uid = UserId;
                                String action = "You Published Post" ;
                                String date = gettingTimeAndDate.GetDate();
                                String time = gettingTimeAndDate.GetTime();
                                historyClass object = new historyClass(action_id , uid , action , time , date);
                                databaseReference.push().setValue(object);
                                Toast.makeText(MainPostActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                }catch (Exception ex){
                    Toast.makeText(MainPostActivity.this, ""+ex, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void ShowPostActivity(View view){
        try {
            // Go To Next Activity
            Intent intent = new Intent(MainPostActivity.this, showPostsActivity.class);
            intent.putExtra("UID",UserId);
            startActivity(intent);



           // Intent intent3 = new Intent(this , VisitorMainActivity.class);
           // intent.putExtra("UID",UserId);
           // startActivity(intent);

            Toast.makeText(this, "Show Activity", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(this, ""+ex, Toast.LENGTH_SHORT).show();
        }
    }

    public void Logout (View view){
        Intent intent = new Intent(MainPostActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}

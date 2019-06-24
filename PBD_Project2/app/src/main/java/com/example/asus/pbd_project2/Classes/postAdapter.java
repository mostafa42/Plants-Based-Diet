package com.example.asus.pbd_project2.Classes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.GettingTimeAndDate;
import com.example.asus.pbd_project2.Classes.Users;
import com.example.asus.pbd_project2.Classes.commentClass;
import com.example.asus.pbd_project2.Classes.historyClass;
import com.example.asus.pbd_project2.Classes.postClass;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.Visitor.Posts.showComments;
import com.example.asus.pbd_project2.Visitor.Posts.showPostsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Mostafa on 13/04/2019.
 */

public class postAdapter extends ArrayAdapter<postClass> {

    Context context;
    showPostsActivity object ;
    String NameOfCommenter ;
    String comment_id , CommentText ;
    DatabaseReference reference ;

    public postAdapter(Context context, ArrayList<postClass> post) {
        super(context, 0, post);
        this.context = context;
        object = new showPostsActivity();
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            // Get the data item for this position
            final postClass postClassObject = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_posts, parent, false);
            }

            // Variables Section
            TextView username;
            TextView postContainerText;
            final EditText make_comment ;
            ImageView send_icon , show_icon ;

            // Define The Components Section
            username = convertView.findViewById(R.id.username); // Username
            postContainerText = convertView.findViewById(R.id.post_content_edit_text);
            make_comment = convertView.findViewById(R.id.comment_container);
            send_icon = convertView.findViewById(R.id.send_btn);
            show_icon = convertView.findViewById(R.id.show_comments_btn);



            send_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        reference = FirebaseDatabase.getInstance().getReference("Comments");
                        comment_id = reference.push().getKey(); // commentid
                        CommentText = make_comment.getText().toString(); // comment

                        if (CommentText.equals("")) {
                            Toast.makeText(context, "Please insert Comment", Toast.LENGTH_SHORT).show();
                        } else {
                            // object from comment class


                            SharedPreferences shared = getContext().getSharedPreferences("Data" , Context.MODE_PRIVATE);
                            final String CommenterId = shared.getString("CommId" , "NULL");
                            if(CommenterId.equals("NULL")){
                                Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(context, "Commenter id is ==>"+CommenterId, Toast.LENGTH_SHORT).show();
                            }


                            DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Users");
                            reference2.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                                        Users user = snapshot.getValue(Users.class);
                                        if(CommenterId.equals(user.getUid())){
                                            NameOfCommenter = user.getUname();
                                            commentClass comments = new commentClass(comment_id, postClassObject.getId(), CommenterId, "Mostafa Gamal", CommentText);
                                            comments.setCommentid(comment_id);
                                            comments.setPostid(postClassObject.getId());
                                            comments.setUserid(CommenterId);
                                            comments.setUsername(NameOfCommenter);
                                            comments.setComment(CommentText);
                                            // pushing in database
                                            reference.push().setValue(comments);
                                            Toast.makeText(context, "The Comment Is Inserted", Toast.LENGTH_SHORT).show();
                                            make_comment.setText("");
                                            Toast.makeText(context, ""+NameOfCommenter, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    // Save History
                                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("History");
                                    GettingTimeAndDate gettingTimeAndDate = new GettingTimeAndDate();
                                    String action_id = databaseReference.push().getKey();
                                    String uid = CommenterId;
                                    String action = "You Commented On Post Post" ;
                                    String date = gettingTimeAndDate.GetDate();
                                    String time = gettingTimeAndDate.GetTime();
                                    historyClass object = new historyClass(action_id , uid , action , time , date);
                                    databaseReference.push().setValue(object);
                                    Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });



                        }
                    }catch (Exception ex){
                        Toast.makeText(context, ""+ex, Toast.LENGTH_SHORT).show();
                    }
                }
            });

            show_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Intent show = new Intent(context, showComments.class);
                        SharedPreferences sharedPreferences = context.getSharedPreferences("Data", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("post_ids", postClassObject.getId());
                        editor.commit();
                        context.startActivity(show);
                        Toast.makeText(context, "Show", Toast.LENGTH_SHORT).show();
                    }catch (Exception ex){
                        Toast.makeText(context, "In Adapter of Post "+ex, Toast.LENGTH_LONG).show();
                    }
                }
            });

            // Actions And Methods Section

            String getColorsVar = postClassObject.getColor();

            if(getColorsVar.equals("111")){ // Blue
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    postContainerText.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_create_post_blue));
                } else {
                    postContainerText.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_create_post_blue));
                }
            }else if(getColorsVar.equals("222")){ // Black
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    postContainerText.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_create_post_black));
                } else {
                    postContainerText.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_create_post_black));
                }
            }else if (getColorsVar.equals("333")){ // Red
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    postContainerText.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_create_post_red));
                } else {
                    postContainerText.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_create_post_red));
                }
            }else if(getColorsVar.equals("444")){ // Default
                final int sdk = android.os.Build.VERSION.SDK_INT;
                if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    postContainerText.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.custom_create_post_default));
                } else {
                    postContainerText.setBackground(ContextCompat.getDrawable(context, R.drawable.custom_create_post_default));
                }
            }

            // Getting From Classes Section
            postContainerText.setText(postClassObject.getPost());
            username.setText(postClassObject.getUname());

        }catch (Exception ex){
            Toast.makeText(context, "postAdapter ==> "+ex, Toast.LENGTH_LONG).show();
            Toast.makeText(context, "postAdapter ==> "+ex, Toast.LENGTH_LONG).show();
            Toast.makeText(context, "postAdapter ==> "+ex, Toast.LENGTH_LONG).show();
        }
        return convertView;
    }

}

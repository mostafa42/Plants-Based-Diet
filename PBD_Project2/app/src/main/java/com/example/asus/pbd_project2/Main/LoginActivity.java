package com.example.asus.pbd_project2.Main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.GettingTimeAndDate;
import com.example.asus.pbd_project2.Classes.Users;
import com.example.asus.pbd_project2.Classes.historyClass;
import com.example.asus.pbd_project2.Classes.postAdapter;
import com.example.asus.pbd_project2.Classes.postClass;
import com.example.asus.pbd_project2.My_Dashboard.AdminLayoutActivity;
import com.example.asus.pbd_project2.My_Dashboard.LayoutActivity;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.Visitor.Posts.showPostsActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText username , password ;
    Button btnLogin ;
    String name , pass ;
    int Count = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                name = username.getText().toString();
                pass = password.getText().toString();

                if (name.equals("") || name.equals(" ") || pass.equals("") || pass.equals(" ")) {
                    Toast.makeText(LoginActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                } else {
                    //validation
                    if (name.equals("") || name.equals(" ") || pass.equals("") || pass.equals(" ")) {
                        Toast.makeText(LoginActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                    } else {
                        DatabaseReference db = FirebaseDatabase.getInstance().getReference("Users");
                        db.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    Users userObject = snapshot.getValue(Users.class);
                                    if (name.equals(userObject.getUname()) && pass.equals(userObject.getPass())) {
                                        Count++;
                                        if (userObject.getUtype().equals("user")) {

                                            Intent intent = new Intent(LoginActivity.this, LayoutActivity.class);
                                            intent.putExtra("UID", userObject.getUid());
                                            intent.putExtra("Loc", userObject.getLoc());
                                            startActivity(intent);
                                            username.setText("");
                                            password.setText("");
                                            // Toast.makeText(LoginActivity.this, ""+Count, Toast.LENGTH_SHORT).show();
                                            Toast.makeText(LoginActivity.this, "Loggened Successfully", Toast.LENGTH_SHORT).show();
                                            break;
                                        } else if (userObject.getUtype().equals("admin")) {
                                            try{
                                            Count++;
                                            Intent intent = new Intent(LoginActivity.this, AdminLayoutActivity.class);
                                            intent.putExtra("UID", userObject.getUid());
                                            intent.putExtra("Loc", userObject.getLoc());
                                            startActivity(intent);
                                            username.setText("");
                                            password.setText("");
                                            //Toast.makeText(LoginActivity.this, ""+Count, Toast.LENGTH_SHORT).show();
                                            break;
                                        }catch(Exception ex){
                                                Toast.makeText(LoginActivity.this, "Btn ==> "+ex, Toast.LENGTH_SHORT).show();
                                        }
                                        }
                                    } else {
                                        // Toast.makeText(LoginActivity.this, ""+Count, Toast.LENGTH_SHORT).show();
                                        Toast.makeText(LoginActivity.this, "Your Username Or Passeord Are Wrong", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                }
                }catch(Exception ex){
                    Toast.makeText(LoginActivity.this, "login "+ex, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

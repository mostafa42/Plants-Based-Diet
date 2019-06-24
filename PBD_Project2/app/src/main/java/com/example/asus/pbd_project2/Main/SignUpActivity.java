package com.example.asus.pbd_project2.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.GettingTimeAndDate;
import com.example.asus.pbd_project2.Classes.Users;
import com.example.asus.pbd_project2.Classes.historyClass;
import com.example.asus.pbd_project2.My_Dashboard.AdminLayoutActivity;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText fullname , username , password , repassword , phone , location ;
    Button btnSignIn ;
    String full , name , pass , repass , phoneNum , locationValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.rePassword);
        phone = (EditText) findViewById(R.id.phone);
        location = (EditText) findViewById(R.id.location);

        btnSignIn = (Button) findViewById(R.id.btn_signup);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    full = fullname.getText().toString();
                    name = username.getText().toString();
                    pass = password.getText().toString();
                    repass = repassword.getText().toString();
                    phoneNum = phone.getText().toString();
                    locationValue = location.getText().toString();

                    if(full.equals("") || full.equals(" ") || name.equals("") || name.equals(" ") || pass.equals("") || pass.equals(" ") || repass.equals("") || repass.equals(" ") || locationValue.equals("") || locationValue.equals(" ") ){
                        Toast.makeText(SignUpActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                    }else if(name.length() < 7 || pass.length() < 7 || phoneNum.length() < 11){
                        Toast.makeText(SignUpActivity.this, "Please Insert valid data", Toast.LENGTH_SHORT).show();
                    }else {
                        if(pass.equals(repass)){
                            DatabaseReference db = FirebaseDatabase.getInstance().getReference("Users");
                            String ID = db.push().getKey();
                            Users userObject = new Users(ID , full , name , phoneNum ,  pass , "user" , locationValue);
                            db.push().setValue(userObject);
                            Toast.makeText(SignUpActivity.this, "You Signned Up Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                            fullname.setText("");
                            username.setText("");
                            password.setText("");
                            repassword.setText("");
                            phone.setText("");
                            location.setText("");

                            // Save History
                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("History");
                            GettingTimeAndDate gettingTimeAndDate = new GettingTimeAndDate();
                            String action_id = databaseReference.push().getKey();
                            String uid = ID;
                            String action = "You Published Post" ;
                            String date = gettingTimeAndDate.GetDate();
                            String time = gettingTimeAndDate.GetTime();
                            historyClass object = new historyClass(action_id , uid , action , time , date);
                            databaseReference.push().setValue(object);

                        }else {
                            Toast.makeText(SignUpActivity.this, "Please Insert same password", Toast.LENGTH_SHORT).show();
                        }
                    }
                   // Toast.makeText(SignUpActivity.this, "To Admin", Toast.LENGTH_SHORT).show();
                }catch (Exception ex){
                    Toast.makeText(SignUpActivity.this, ""+ex, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

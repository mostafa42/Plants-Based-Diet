package com.example.asus.pbd_project2.My_Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.Main.SignUpActivity;
import com.example.asus.pbd_project2.R;

public class MyHomeActivity extends AppCompatActivity {
    private Button btnSignin;
    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home);


        Button btnlogin = (Button) findViewById(R.id.login);
        Button btnSignin = (Button) findViewById(R.id.signin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyHomeActivity.this, LoginActivity.class));
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyHomeActivity.this, SignUpActivity.class));
            }
        });


    }
}

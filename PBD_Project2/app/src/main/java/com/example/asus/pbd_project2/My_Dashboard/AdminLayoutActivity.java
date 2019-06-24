package com.example.asus.pbd_project2.My_Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asus.pbd_project2.Admins.AdminsActivity;
import com.example.asus.pbd_project2.Clinic.ClinicActivity;
import com.example.asus.pbd_project2.Diseases.DiseasesActivity;
import com.example.asus.pbd_project2.DrinksImage.AddDrinksActivity;
import com.example.asus.pbd_project2.FeedBack.UFeedbackListActivity;
import com.example.asus.pbd_project2.Ingrediant.ingrediantActivity;
import com.example.asus.pbd_project2.LegumesActivity;
import com.example.asus.pbd_project2.LegumesListActivity;
import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.Restaurant.RestaurantActivity;
import com.example.asus.pbd_project2.SweetFood.SweetFoodActivity;
import com.example.asus.pbd_project2.UPloadImage1.MainActivity;
import com.example.asus.pbd_project2.Visitor.Posts.showPostsActivity;

public class AdminLayoutActivity extends AppCompatActivity {
    private LinearLayout linear1 , linear2 , linear3 ,
            linear4 , linear5 , linear6 , linear7 , linear8  , linear9,  linear10 /* linear11*/ , linear12 ;
    String UserId ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    try{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_layout);

        // Get Id From Previous Activity
        Intent intent = getIntent();
        UserId = intent.getStringExtra("UID");
        Toast.makeText(this, "ID Recived  ==>  " + UserId, Toast.LENGTH_SHORT).show();


        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        linear3 = (LinearLayout) findViewById(R.id.linear3);
        linear4 = (LinearLayout) findViewById(R.id.linear4);
        linear5 = (LinearLayout) findViewById(R.id.linear5);
        linear6 = (LinearLayout) findViewById(R.id.linear6);
        linear7 = (LinearLayout) findViewById(R.id.linear7);
        linear8 = (LinearLayout) findViewById(R.id.linear8);
        linear9 = (LinearLayout) findViewById(R.id.linear9);

        linear10 = (LinearLayout) findViewById(R.id.linear10);
       // linear11 = (LinearLayout) findViewById(R.id.linear11);
        linear12 = (LinearLayout) findViewById(R.id.linear12);

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // food
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //linear 2

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Drinks

                //ast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, AddDrinksActivity.class);
                startActivity(intent);
            }
        });
        //linear3

        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Sweet Foods
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, SweetFoodActivity.class);
                startActivity(intent);
            }
        });

        //linear4
        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Food Colories
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, ingrediantActivity.class);
                startActivity(intent);
            }
        });
        //linear 5
        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Fruit Col
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, LegumesActivity.class);
                startActivity(intent);
            }
        });

        //linear 6
        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Plan
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, showPostsActivity.class);
                startActivity(intent);
            }
        });

        //linear7
        linear7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Resturnats
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });

        //linear8
        linear8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Clinics
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, ClinicActivity.class);
                startActivity(intent);
            }
        });

        //linear9
        linear9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Diseases
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, DiseasesActivity.class);
                startActivity(intent);
            }
        });

        //linear10
        linear10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Admin
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //linear12
        linear12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // Feedback
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminLayoutActivity.this, UFeedbackListActivity.class);
                startActivity(intent);
            }
        });
    }catch(Exception ex){
        Toast.makeText(this, "Btn == > "+ex, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Btn == > "+ex, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Btn == > "+ex, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Btn == > "+ex, Toast.LENGTH_LONG).show();
    }

    }
}

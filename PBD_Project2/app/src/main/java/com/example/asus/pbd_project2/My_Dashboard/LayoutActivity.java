package com.example.asus.pbd_project2.My_Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.asus.pbd_project2.Clinic.UClinicListActivity;
import com.example.asus.pbd_project2.Diseases.UDiseasesListActivity;
import com.example.asus.pbd_project2.DrinksImage.ShowDrinksActivity;
import com.example.asus.pbd_project2.FeedBack.FeedbackActivity;
import com.example.asus.pbd_project2.FeedBack.UFeedbackListActivity;
import com.example.asus.pbd_project2.Ingrediant.UIngrediantListActivity;

import com.example.asus.pbd_project2.LegumesListActivity;
import com.example.asus.pbd_project2.Products.ShowProuductsActivity;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.Restaurant.URestaurantListActivity;
import com.example.asus.pbd_project2.SweetFood.ShoweSweetActivity;
import com.example.asus.pbd_project2.Tips.TipsActivity;
import com.example.asus.pbd_project2.UPloadImage1.MainActivity;
import com.example.asus.pbd_project2.UPloadImage1.ShowImagesActivity;
import com.example.asus.pbd_project2.Visitor.GetCloseClinicActivity;
import com.example.asus.pbd_project2.Visitor.History.ShowHistoryActivity;
import com.example.asus.pbd_project2.Visitor.MealsWithAvailableComponents.mealsWithAvailableComponentActivity;
import com.example.asus.pbd_project2.Visitor.Plans.MainPlanActivity;
import com.example.asus.pbd_project2.Visitor.Posts.MainPostActivity;

public class LayoutActivity extends AppCompatActivity {
private LinearLayout linear1 , linear2 , linear3 , linear4 , linear5 , linear6 , linear7 , linear8 , linear9,  linear10 , linear11 , linear12 , linear13 , linear14 , linear15 ;
    String UserId  , UserLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        // Get Id From Previous Activity
        Intent intent = getIntent();
        UserId = intent.getStringExtra("UID");
        UserLoc = intent.getStringExtra("Loc");

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
        linear11 = (LinearLayout) findViewById(R.id.linear11);
        linear12 = (LinearLayout) findViewById(R.id.linear12);
        linear13 = (LinearLayout) findViewById(R.id.linear13);
        linear14 = (LinearLayout) findViewById(R.id.linear14);
        linear15 = (LinearLayout) findViewById(R.id.linear15);

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, ShowImagesActivity.class);
                startActivity(intent);
            }
        });
        //linear 2

        linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, ShowDrinksActivity.class);
                startActivity(intent);
            }
        });
        //linear3

        linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, ShoweSweetActivity.class);
                startActivity(intent);
            }
        });

        //linear4
        linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, UIngrediantListActivity.class);
                startActivity(intent);
            }
        });
        //linear 5
        linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, UIngrediantListActivity.class);
                startActivity(intent);
            }
        });

        //linear 6
        linear6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, MainPlanActivity.class);
                startActivity(intent);
            }
        });

        //linear7
        linear7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, URestaurantListActivity.class);
                startActivity(intent);
            }
        });

        //linear8
        linear8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{}catch (Exception ex){
                    Toast.makeText(LayoutActivity.this, " Call ==> "+ex, Toast.LENGTH_SHORT).show();
                    // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(LayoutActivity.this, UClinicListActivity.class);
                    //startActivity(intent);
                }

            }
        });

        //linear9
        linear9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, UDiseasesListActivity.class);
                startActivity(intent);
            }
        });

        //linear10
        linear10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, ShowProuductsActivity.class);
                startActivity(intent);
            }
        });
        //linear11
        linear11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, TipsActivity.class);
                startActivity(intent);
            }
        });
        //linear12
        linear12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, FeedbackActivity.class);
                startActivity(intent);
            }
        });
        //linear13
        linear13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, mealsWithAvailableComponentActivity.class);
                startActivity(intent);
            }
        });
        //linear14
        linear14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, MainPostActivity.class);
                // Get Id From Previous Activity
                intent.putExtra("UID", UserId);
                startActivity(intent);

            }
        });
        //linear15
        linear15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText( LayoutActivity.this , "you have linear" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(LayoutActivity.this, ShowHistoryActivity.class);
                // Get Id From Previous Activity
                intent.putExtra("UID", UserId);
                startActivity(intent);
            }
        });


    }

    public  void Go (View view){
        Intent intent = new Intent(LayoutActivity.this , GetCloseClinicActivity.class);
        intent.putExtra("Loc" , UserLoc);
        startActivity(intent);
    }

}

package com.example.asus.pbd_project2.Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.asus.pbd_project2.DrinksImage.AddDrinksActivity;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.SweetFood.ShoweSweetActivity;
import com.example.asus.pbd_project2.SweetFood.SweetFoodActivity;
import com.example.asus.pbd_project2.UPloadImage1.MainActivity;
import com.example.asus.pbd_project2.UPloadImage1.ShowImagesActivity;

public class HomepageActivity extends AppCompatActivity implements View.OnClickListener{
private CardView cliniccard , restaurantcard , adminscard , ingrediantscard ,foodcard ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //definding cards

        cliniccard =(CardView) findViewById(R.id.clinicid);
        restaurantcard =(CardView) findViewById(R.id.restaurantid);
        adminscard =(CardView) findViewById(R.id.adminsid);
        ingrediantscard=(CardView) findViewById(R.id.ingrediantsid);
        foodcard =(CardView) findViewById(R.id.Foodid);
         // Add click listner to cards

        cliniccard.setOnClickListener(this);
        restaurantcard.setOnClickListener(this);
        adminscard.setOnClickListener(this);
        ingrediantscard.setOnClickListener(this);
        foodcard.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.clinicid :i = new Intent(this , MainActivity.class);
           startActivity(i); break;

            case R.id.restaurantid :i = new Intent(this , ShowImagesActivity.class);
                startActivity(i); break;
            case R.id.adminsid :i = new Intent(this , SweetFoodActivity.class);
                startActivity(i);break;
            case R.id.ingrediantsid :i = new Intent(this , ShoweSweetActivity.class);
                startActivity(i);  break;
            case R.id.Foodid :i = new Intent(this , AddDrinksActivity.class);
                startActivity(i);  break;
            default:break;
        }
    }
}

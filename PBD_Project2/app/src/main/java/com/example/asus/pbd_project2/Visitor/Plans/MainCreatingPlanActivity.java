package com.example.asus.pbd_project2.Visitor.Plans;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Admins.AdminsActivity;
import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.R;

public class MainCreatingPlanActivity extends AppCompatActivity {

    Button vegetables , fruits , cereales ;
    TextView value ;
    float VegetablesRatio , fruitRation , cerealesRation , AllRatios ;
    int DEFAULT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_creating_plan);

        SharedPreferences sharedPreferences = getSharedPreferences("Value", Context.MODE_PRIVATE);
        final int Result = sharedPreferences.getInt("coloiesValue", DEFAULT);

        value = (TextView) findViewById(R.id.data);
        String Value = String.valueOf(Result);

        try {

            AllRatios = Result / 3;

        } catch (Exception ex) {
            Toast.makeText(this, "" + ex, Toast.LENGTH_LONG).show();
        }


        vegetables = (Button) findViewById(R.id.vegetables_products);
        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Make Ratio For Vegetables

                try {
                    VegetablesRatio = AllRatios;
                } catch (Exception ex) {
                    Toast.makeText(MainCreatingPlanActivity.this, "" + ex, Toast.LENGTH_SHORT).show();
                }


                // Saving Value in Shared Perferances

                SharedPreferences sharedPreferences = getSharedPreferences("VegetablesRation", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("VegetablescoloiesValue", VegetablesRatio);
                editor.commit();

                Intent intent = new Intent(MainCreatingPlanActivity.this, VegetablesProductsActivity.class);
                startActivity(intent);


            }
        });

        fruits = (Button) findViewById(R.id.fruits_products);
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Make Ratio For fruits

                fruitRation = AllRatios;


                // Saving Value in Shared Perferances


                SharedPreferences sharedPreferences = getSharedPreferences("FruitsRation", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("FruitscoloiesValue", fruitRation);
                editor.commit();


                Intent intent = new Intent(MainCreatingPlanActivity.this, FruitsProductsActivity.class);
                startActivity(intent);

            }
        });

        cereales = (Button) findViewById(R.id.cereals_and_pulses_products);
        cereales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Make Ratio For cereales

                cerealesRation = AllRatios;

                // Saving Value in Shared Perferances


                SharedPreferences sharedPreferences = getSharedPreferences("CerealesRation", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("CerealescoloiesValue", cerealesRation);
                editor.commit();

                Intent intent = new Intent(MainCreatingPlanActivity.this, CerealsAndPulsesProductsActivity.class);
                startActivity(intent);

            }
        });
    }


    public void Logout (View view){
        Intent intent = new Intent(MainCreatingPlanActivity.this , LoginActivity.class);
        startActivity(intent);
        }
    }


package com.example.asus.pbd_project2.Visitor.Plans.Meals.Plan2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.R;

public class ClassifyMealsActivityPlan2 extends AppCompatActivity {

    Button BreakFast , Lunch , Dinner ;
    TextView valuetxt ;
    int DEFAULT = 0 ;
    int Result ;
    int LunchInt , DinnerInt , BreakfastInt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify_meals_plan2);

        SharedPreferences sharedPreferences = getSharedPreferences("Value" , Context.MODE_PRIVATE);
        Result =  sharedPreferences.getInt("coloiesValue" , DEFAULT);

        BreakFast = (Button) findViewById(R.id.breakfast);
        BreakFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Saving Value in Shared Perferances
                    SharedPreferences sharedPreferences = getSharedPreferences("Value", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("coloiesValue", (int) Result);
                    editor.commit();

                    Intent intent = new Intent(ClassifyMealsActivityPlan2.this, BreakFastActivityPlan2.class);
                    startActivity(intent);
                }catch (Exception ex){
                    Toast.makeText(ClassifyMealsActivityPlan2.this, ""+ex, Toast.LENGTH_LONG).show();
                }
            }
        });
        Lunch = (Button) findViewById(R.id.lunch);
        Lunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    // Saving Value in Shared Perferances
                    SharedPreferences sharedPreferences = getSharedPreferences("Value" , MODE_PRIVATE);
                    SharedPreferences.Editor  editor = sharedPreferences.edit();
                    editor.putInt("coloiesValue" , (int) Result);
                    editor.commit();
                    Intent intent = new Intent(ClassifyMealsActivityPlan2.this, LunchActivityPlan2.class);
                    startActivity(intent);
                }catch(Exception ex){
                    Toast.makeText(ClassifyMealsActivityPlan2.this, ""+ex, Toast.LENGTH_LONG).show();
                }
            }
        });
        Dinner = (Button) findViewById(R.id.dinner);
        Dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Saving Value in Shared Perferances
                    SharedPreferences sharedPreferences = getSharedPreferences("Value" , MODE_PRIVATE);
                    SharedPreferences.Editor  editor = sharedPreferences.edit();
                    editor.putInt("coloiesValue" , (int) Result);
                    editor.commit();
                    Intent intent = new Intent(ClassifyMealsActivityPlan2.this, DinnerActivityPlan2.class);
                    startActivity(intent);
                }catch (Exception ex){
                    Toast.makeText(ClassifyMealsActivityPlan2.this, ""+ex, Toast.LENGTH_LONG).show();}
            }
        });
    }
}

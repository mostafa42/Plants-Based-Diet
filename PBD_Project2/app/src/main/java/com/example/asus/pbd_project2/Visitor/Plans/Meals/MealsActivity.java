package com.example.asus.pbd_project2.Visitor.Plans.Meals;

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
import com.example.asus.pbd_project2.Visitor.Plans.MainCreatingPlanActivity;
import com.example.asus.pbd_project2.Visitor.Plans.Meals.Plan1.ClassifyMealsActivityPlan1;
import com.example.asus.pbd_project2.Visitor.Plans.Meals.Plan2.ClassifyMealsActivityPlan2;

public class MealsActivity extends AppCompatActivity {

    Button plan1 , plan2 , others;
    TextView txt , txt2 ;
    int DEFAULT = 0 ;
    int Result ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_meals);

            SharedPreferences sharedPreferences = getSharedPreferences("Value" , Context.MODE_PRIVATE);
            Result =  sharedPreferences.getInt("coloiesValue" , DEFAULT);

            plan1 = (Button) findViewById(R.id.plan_1);

            plan1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Saving Value in Shared Perferances
                    SharedPreferences sharedPreferences = getSharedPreferences("Value" , MODE_PRIVATE);
                    SharedPreferences.Editor  editor = sharedPreferences.edit();
                    editor.putInt("coloiesValue" , (int) Result);
                    editor.commit();

                    Intent intent = new Intent(MealsActivity.this, ClassifyMealsActivityPlan1.class);
                    startActivity(intent);
                }
            });

            txt = (TextView) findViewById(R.id.value);
            if(Result == 0){
                txt.setText("0");
            }else {

                int Lunch = Result / 2 ;
                int Dinner = (int) ((Result - Lunch) * 0.20);
                int Breakfast  = Lunch - Dinner ;

                String value1 = String.valueOf(Lunch);
                String value2 = String.valueOf(Dinner);
                String value3 = String.valueOf(Breakfast);
                txt.setText("Lunch = "+value1 + "\n" + "Dinner = "+value2+ "Breakfast = "+value3);
            }


            plan2 = (Button) findViewById(R.id.plan_2);

            plan2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Saving Value in Shared Perferances
                    SharedPreferences sharedPreferences = getSharedPreferences("Value" , MODE_PRIVATE);
                    SharedPreferences.Editor  editor = sharedPreferences.edit();
                    editor.putInt("coloiesValue" , (int) Result);
                    editor.commit();
                    Intent intent = new Intent(MealsActivity.this, ClassifyMealsActivityPlan2.class);
                    startActivity(intent);
                }
            });

            txt2 = (TextView) findViewById(R.id.value2);
            if(Result == 0){
                txt.setText("0");
            }else {

                int Lunch2 = Result / 2 ;
                int Dinner2 = (int) ((Result - Lunch2) * 0.20);
                int Breakfast2  = Lunch2 - Dinner2 ;

                String value11 = String.valueOf(Lunch2);
                String value22= String.valueOf(Dinner2);
                String value32 = String.valueOf(Breakfast2);
                txt2.setText("Lunch = "+value11 + "\n" + "Dinner = "+value22+ "Breakfast = "+value32);
            }

            others = (Button) findViewById(R.id.options);
            others.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MealsActivity.this , MainCreatingPlanActivity.class);
                    startActivity(intent);
                }
            });


        }catch (Exception ex){
            Toast.makeText(this, "MealsActivity ==> "+ex, Toast.LENGTH_LONG).show();
        }

    }

    public void Logout (View view){
        Intent intent = new Intent(MealsActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}

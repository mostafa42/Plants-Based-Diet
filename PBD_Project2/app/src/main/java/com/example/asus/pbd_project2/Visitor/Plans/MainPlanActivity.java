package com.example.asus.pbd_project2.Visitor.Plans;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Admins.AdminsActivity;
import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.R;
import com.example.asus.pbd_project2.Visitor.Plans.Meals.MealsActivity;

public class MainPlanActivity extends AppCompatActivity {

    RadioButton male , fmale ;
    EditText weight , length , age ;
    Spinner active_statue ;
    Button calculate , plan_activity ;
    TextView result ;

    int DEFAULT = 0 ;
    
    
    String gender;
    String statue;
    String weightValue;
    String lengthValue;
    String ageValue;
    double coloriesValue;
    String resultValue ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_plan);
        
        // Get Ids from layout 
        male = (RadioButton) findViewById(R.id.male);
        fmale = (RadioButton) findViewById(R.id.fmale);
        
        weight = (EditText) findViewById(R.id.weight_edit_text);
        length = (EditText) findViewById(R.id.length_edit_text);
        age = (EditText) findViewById(R.id.age_edit_text);
        
        active_statue = (Spinner) findViewById(R.id.choose_active);
        
        result = (TextView) findViewById(R.id.result);

        
        calculate = (Button) findViewById(R.id.calc_only);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check Validation
                try {
                    // Assign If he is male or fmale
                    if (male.isChecked()) {
                        gender = "male";
                    } else if (fmale.isChecked()) {
                        gender = "fmale";
                    }


                    // Assign statue
                    if(active_statue.getSelectedItem().equals("")){
                        statue = "";
                    }else if(active_statue.getSelectedItem().equals("low")){
                        statue = "low" ;
                    }else if(active_statue.getSelectedItem().equals("mid")){
                        statue = "mid" ;
                    }else if(active_statue.getSelectedItem().equals("hight")){
                        statue = "hight";
                    }

                    //Assign Edit Texts And Texts View
                    weightValue = weight.getText().toString();
                    lengthValue = length.getText().toString();
                    ageValue    = age.getText().toString();

                    // Convert The Strings to int for checking
                    int weightInt = Integer.parseInt(weightValue);
                    int lengthInt = Integer.parseInt(lengthValue);
                    int ageInt = Integer.parseInt(ageValue);

                    // Check Validation
                    if(weightValue.equals("") || lengthValue.equals("") || ageValue.equals("") || statue.equals("") || gender.equals("")){
                        Toast.makeText(MainPlanActivity.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                    }else if(weightInt > 300 ||  weightInt < 50 || ageInt > 80 || ageInt < 10 || lengthInt > 210 || lengthInt < 100 ){
                        Toast.makeText(MainPlanActivity.this, "Invalid Data", Toast.LENGTH_SHORT).show();
                    }else {
                        // if male
                        if(gender.equals("male")){
                            if(statue.equals("low")){
                                coloriesValue = ( (10 * weightInt) + (6.25 * lengthInt) + (5 * ageInt) + 5 ) * 1.2;
                            }else if(statue.equals("mid")){
                                coloriesValue = ( (10 * weightInt) + (6.25 * lengthInt) + (5 * ageInt) + 5 ) * 1.3;
                            }else if(statue.equals("hight")){
                                coloriesValue = ( (10 * weightInt) + (6.25 * lengthInt) + (5 * ageInt) + 5 ) * 1.4;
                            }
                            // if fmale
                        }else if(gender.equals("fmale")){
                            if(statue.equals("low")){
                                coloriesValue = ( (10 * weightInt) + (6.25 * lengthInt) + (5 * ageInt) - 161 ) * 1.2;
                            }else if(statue.equals("mid")){
                                coloriesValue = ( (10 * weightInt) + (6.25 * lengthInt) + (5 * ageInt) - 161 ) * 1.3;
                            }else if(statue.equals("hight")){
                                coloriesValue = ( (10 * weightInt) + (6.25 * lengthInt) + (5 * ageInt) - 161 ) * 1.4;
                            }
                        }

                        resultValue = String.valueOf(coloriesValue);
                        result.setText(resultValue);



                        // Saving Value in Shared Perferances
                       SharedPreferences sharedPreferences = getSharedPreferences("Value" , MODE_PRIVATE);
                       SharedPreferences.Editor  editor = sharedPreferences.edit();
                       editor.putInt("coloiesValue" , (int) coloriesValue);
                       editor.commit();

                        Toast.makeText(MainPlanActivity.this, "Calculation Done", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception ex){
                    Toast.makeText(MainPlanActivity.this, ""+ex, Toast.LENGTH_LONG).show();
                }
            }
        });

        plan_activity = (Button) findViewById(R.id.go_to_make_plan);
        plan_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                    try {
                        SharedPreferences sharedPreferences = getSharedPreferences("Value" , Context.MODE_PRIVATE);
                        int Result = sharedPreferences.getInt("coloiesValue" , DEFAULT);
                        Intent intent = new Intent(MainPlanActivity.this, MealsActivity.class);
                        startActivity(intent);
                        Toast.makeText(MainPlanActivity.this, "" + Result, Toast.LENGTH_SHORT).show();
                    }catch (Exception ex){
                        Toast.makeText(MainPlanActivity.this, "MainPlanActivity ==> "+ex, Toast.LENGTH_LONG).show();
                    }

            }
        });
    }

    public void Logout (View view){
        Intent intent = new Intent(MainPlanActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}

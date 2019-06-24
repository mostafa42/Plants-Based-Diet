package com.example.asus.pbd_project2.Visitor.MealsWithAvailableComponents;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.asus.pbd_project2.Admins.AdminsActivity;
import com.example.asus.pbd_project2.Main.LoginActivity;
import com.example.asus.pbd_project2.R;

public class mealsWithAvailableComponentActivity extends AppCompatActivity {

    Spinner first , second , third ;
    String select1 , select2 , select3 ;
    Button btn_Select ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals_with_available_component);

        first = (Spinner) findViewById(R.id.first_component);
        second = (Spinner) findViewById(R.id.second_component);
        third = (Spinner) findViewById(R.id.third_component);

        btn_Select = (Button) findViewById(R.id.btnthirdComponent);
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                select1 = first.getSelectedItem().toString();
                select2 = second.getSelectedItem().toString();
                select3 = third.getSelectedItem().toString();

                if(select1.equals(select2) || select1.equals(select3) || select2.equals(select3)){
                    Toast.makeText(mealsWithAvailableComponentActivity.this, "Please Insert Different Components", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences sharedPreferences1 = getSharedPreferences("firstComp" , MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                    editor1.putString("Comp1" , select1);
                    editor1.commit();

                    Intent intent = new Intent(mealsWithAvailableComponentActivity.this , ResultOfAvailableComponentsActivity.class);
                    startActivity(intent);
                }

            }
        });

    }

    public void Logout (View view){
        Intent intent = new Intent(mealsWithAvailableComponentActivity.this , LoginActivity.class);
        startActivity(intent);
    }

}

package com.example.asus.pbd_project2.Visitor.Plans.Meals.Plan2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.MealsAdapter;
import com.example.asus.pbd_project2.Classes.MealsClass;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LunchActivityPlan2 extends AppCompatActivity {

    ArrayList<MealsClass> arrayOfMeals ;
    ListView listView;
    MealsAdapter adapter ;

    int Result , DEFAULT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_plan2);

        SharedPreferences sharedPreferences = getSharedPreferences("Value" , Context.MODE_PRIVATE);
        Result =  sharedPreferences.getInt("coloiesValue" , DEFAULT);

        listView = (ListView) findViewById(R.id.lunch_listview2);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Meals").child("Plan2").child("Dinner");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayOfMeals = new ArrayList<MealsClass>();
                for (DataSnapshot mealSnapShat : dataSnapshot.getChildren()) {
                    MealsClass object = mealSnapShat.getValue(MealsClass.class);
                    //arrayOfMeals.add(object);
                   // int ValueDB = Integer.parseInt(object.getTotal());
                    // if(Result >= ValueDB){
                        arrayOfMeals.add(object);
                    // }
                }

                adapter = new MealsAdapter(LunchActivityPlan2.this, arrayOfMeals);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}

package com.example.asus.pbd_project2.Visitor.MealsWithAvailableComponents;

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

public class ResultOfAvailableComponentsActivity extends AppCompatActivity {

    ArrayList<MealsClass> arrayOfMeals;
    ListView listView1, listView2, listView3;
    MealsAdapter adapter;
    String Select1, Select2, Select3, DEFAULT = "NULL";
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_of_available_components);

        SharedPreferences sharedPreferences = getSharedPreferences("firstComp", Context.MODE_PRIVATE);
        Select1 = sharedPreferences.getString("Comp1", DEFAULT);


        listView1 = (ListView) findViewById(R.id.listview_mealsBreakfast);

        if(counter == 0){
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Meals").child("Plan1").child("Breakfast");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    arrayOfMeals = new ArrayList<MealsClass>();
                    // All Of There
                    for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                        MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                        if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                            arrayOfMeals.add(object);
                            counter++;
                        }
                    }
                    adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                    listView1.setAdapter(adapter);
                    Toast.makeText(ResultOfAvailableComponentsActivity.this, "Breakfase "+counter, Toast.LENGTH_SHORT).show();

                    if (counter == 0) {

                        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Meals").child("Plan1").child("Dinner");
                        reference2.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                arrayOfMeals = new ArrayList<MealsClass>();
                                // All Of Ther
                                for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                                    MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                                    if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                                        arrayOfMeals.add(object);
                                        counter++;
                                    }
                                }
                                adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                                listView1.setAdapter(adapter);

                                if (counter == 0) {

                                    DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Meals").child("Plan1").child("Lunch");
                                    reference2.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {

                                            arrayOfMeals = new ArrayList<MealsClass>();
                                            // All Of Ther
                                            for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                                                MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                                                if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                                                    arrayOfMeals.add(object);
                                                    counter++;
                                                }
                                            }
                                            adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                                            listView1.setAdapter(adapter);


                                            if (counter == 0) {

                                                DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Meals").child("Plan2").child("Breakfast");
                                                reference2.addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {

                                                        arrayOfMeals = new ArrayList<MealsClass>();
                                                        // All Of Ther
                                                        for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                                                            MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                                                            if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                                                                arrayOfMeals.add(object);
                                                                counter++;
                                                            }
                                                        }
                                                        adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                                                        listView1.setAdapter(adapter);

                                                        if (counter == 0) {

                                                            DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Meals").child("Plan2").child("Dinner");
                                                            reference2.addValueEventListener(new ValueEventListener() {
                                                                @Override
                                                                public void onDataChange(DataSnapshot dataSnapshot) {

                                                                    arrayOfMeals = new ArrayList<MealsClass>();
                                                                    // All Of Ther
                                                                    for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                                                                        MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                                                                        if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                                                                            arrayOfMeals.add(object);
                                                                            counter++;
                                                                        }
                                                                    }
                                                                    adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                                                                    listView1.setAdapter(adapter);

                                                                    if (counter == 0) {

                                                                        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Meals").child("Plan2").child("Lunch");
                                                                        reference2.addValueEventListener(new ValueEventListener() {
                                                                            @Override
                                                                            public void onDataChange(DataSnapshot dataSnapshot) {

                                                                                arrayOfMeals = new ArrayList<MealsClass>();
                                                                                // All Of Ther
                                                                                for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                                                                                    MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                                                                                    if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                                                                                        arrayOfMeals.add(object);
                                                                                        counter++;
                                                                                    }
                                                                                }
                                                                                adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                                                                                listView1.setAdapter(adapter);
                                                                            }

                                                                            // All Of Them In Breakfast
                                                                            @Override
                                                                            public void onCancelled(DatabaseError databaseError) {

                                                                            }
                                                                        }); // The Breakfast End
                                                                    }

                                                                }

                                                                // All Of Them In Breakfast
                                                                @Override
                                                                public void onCancelled(DatabaseError databaseError) {

                                                                }
                                                            }); // The Breakfast End
                                                        }

                                                    }

                                                    // All Of Them In Breakfast
                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {

                                                    }
                                                }); // The Breakfast End
                                            }

                                        }

                                        // All Of Them In Breakfast
                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    }); // The Breakfast End
                                }

                            }

                            // All Of Them In Breakfast
                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        }); // The Breakfast End
                    }

                }

                // All Of Them In Breakfast
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            }); // The Breakfast End
        }

/*

        if (counter > 0 || counter == 0) {

            DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("Meals").child("Plan1").child("Dinner");
            reference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    arrayOfMeals = new ArrayList<MealsClass>();
                    // All Of Ther
                    for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                        MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                        if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                            arrayOfMeals.add(object);
                            counter++;
                        }
                    }
                    adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                    listView1.setAdapter(adapter);
                }

                // All Of Them In Breakfast
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            }); // The Breakfast End
        }

        if (counter > 0 || counter == 0) {

            DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference("Meals").child("Plan1").child("Lunch");
            reference3.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    arrayOfMeals = new ArrayList<MealsClass>();
                    // All Of Ther
                    for (DataSnapshot mealsSnapShat : dataSnapshot.getChildren()) {
                        MealsClass object = mealsSnapShat.getValue(MealsClass.class);
                        if (Select1.equals(object.getCompn1()) || Select1.equals(object.getCompn2()) || Select1.equals(object.getCompn3()) || Select1.equals(object.getCompn4()) || Select1.equals(object.getCompn5()) || Select1.equals(object.getCompn6())) {
                            arrayOfMeals.add(object);
                            counter++;
                        }
                    }
                    adapter = new MealsAdapter(ResultOfAvailableComponentsActivity.this, arrayOfMeals);
                    listView1.setAdapter(adapter);
                }

                // All Of Them In Breakfast
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            }); // The Breakfast End
        }
*/


    }
}

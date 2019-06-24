package com.example.asus.pbd_project2.Visitor.Plans;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.pbd_project2.Classes.coloriesAdapter;
import com.example.asus.pbd_project2.Classes.coloriesClass;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CerealsAndPulsesProductsActivity extends AppCompatActivity {

    int DEFAULT = 0 ;
    TextView txt ;
    float counter  ;


    ArrayList<coloriesClass> arrayOfCereals ;
    ListView listView;
    coloriesAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cereals_and_pulses_products);

        counter = 0 ;

        SharedPreferences sharedPreferences = getSharedPreferences("CerealesRation" , Context.MODE_PRIVATE);
        final float Result =  sharedPreferences.getFloat("CerealescoloiesValue" , DEFAULT);

        txt = (TextView) findViewById(R.id.txt_data3);
        final String Result2 = String.valueOf(Result);
        txt.setText(Result2);

        listView = (ListView) findViewById(R.id.cereals_list);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Colories");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                arrayOfCereals = new ArrayList<coloriesClass>();

                for (DataSnapshot fruitsSnapShat : dataSnapshot.getChildren()){

                    coloriesClass object = fruitsSnapShat.getValue(coloriesClass.class);
                    float FruitsColories = Float.parseFloat(object.getColoriesvalue());


                    // Toast.makeText(FruitsProductsActivity.this, object.getClassification(), Toast.LENGTH_SHORT).show();
                    // Toast.makeText(FruitsProductsActivity.this, "1", Toast.LENGTH_SHORT).show();
                    if( object.getClassification().equals("nuts") ) {

                        counter  = counter + FruitsColories;
                        if(counter <= Result){
                            arrayOfCereals.add(object);
                        }
                    }
                }


                adapter = new coloriesAdapter(CerealsAndPulsesProductsActivity.this, arrayOfCereals);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}

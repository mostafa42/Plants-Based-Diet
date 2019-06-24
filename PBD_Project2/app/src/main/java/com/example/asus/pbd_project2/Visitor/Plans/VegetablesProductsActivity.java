package com.example.asus.pbd_project2.Visitor.Plans;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.coloriesAdapter;
import com.example.asus.pbd_project2.Classes.coloriesClass;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VegetablesProductsActivity extends AppCompatActivity {
    String Data = "Null"  ;
    int DEFAULT = 0 ;
    float summition = 0 ;
    TextView txt ;

    ArrayList<coloriesClass> arrayOfVegetables ;
    ListView listView;
    coloriesAdapter adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables_products);

        SharedPreferences sharedPreferences = getSharedPreferences("VegetablesRation" , Context.MODE_PRIVATE);
        final float Result =  sharedPreferences.getFloat("VegetablescoloiesValue" , DEFAULT);

        txt = (TextView) findViewById(R.id.txt_data);
        final String Result2 = String.valueOf(Result);
        txt.setText(Result2);



        listView = (ListView) findViewById(R.id.vegetables_list);



        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Colories");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                arrayOfVegetables = new ArrayList<coloriesClass>();
                for (DataSnapshot vegetablesSnapShat : dataSnapshot.getChildren()){

                    coloriesClass object = vegetablesSnapShat.getValue(coloriesClass.class);
                    float VegetablesColories = Float.parseFloat(object.getColoriesvalue());
                    summition  = summition + VegetablesColories;
                    if(object.getClassification().equals("vegetables")){
                        if(summition > 0) {
                            if (summition <= Result) {
                                arrayOfVegetables.add(object);
                            }
                        }else {
                            Toast.makeText(VegetablesProductsActivity.this, "There Is No Data", Toast.LENGTH_SHORT).show();
                        }
                    }

                }

                adapter = new coloriesAdapter(VegetablesProductsActivity.this, arrayOfVegetables);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        /*
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Colories");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapShat : dataSnapshot.getChildren()){
                    coloriesClass object = postSnapShat.getValue(coloriesClass.class);

                    float VegetablesColories = Float.parseFloat(object.getColoriesvalue());
                    summition  = summition + VegetablesColories;

                    if(summition <= 55){
                        Toast.makeText(VegetablesProductsActivity.this,""+object.getColoriesvalue(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        */

    }
}

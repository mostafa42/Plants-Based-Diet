package com.example.asus.pbd_project2.Restaurant;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.asus.pbd_project2.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RestaurantListActivity extends AppCompatActivity {
    LayoutInflater inflater1;

    int count =0;
    int age;
    String name;
    String location;
    EditText txtname,txtlocattion, txtage,txtsearch;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    RestaurantData data;


    ListView listView;

    ArrayList<RestaurantData> dataArrayList;

    RestaurantApter  customAdapter;

    String key;

    int temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference().child("restaurants");
        key=databaseReference.push().getKey();

       // txtname = (EditText) findViewById(R.id.writename);
      //  txtlocattion= (EditText) findViewById(R.id.writelocation);
      //  txtage = (EditText)findViewById(R.id.writeage);
        listView = (ListView) findViewById(R.id.readlist);

/*
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {

                    name = txtname.getText().toString().trim();



                    if (TextUtils.isEmpty(name) ) {


                        Toast.makeText(getApplicationContext(), "Please Enter Name", Toast.LENGTH_SHORT).show();

                    } else {

                        age = Integer.parseInt(txtage.getText().toString().trim());
                        location = txtlocattion.getText().toString().trim();

                        data = new RestaurantData(databaseReference.push().getKey(), name, age , location);

                        databaseReference.child(data.getKey()).setValue(data);

                        Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show();

                        txtname.setText("");
                        txtage.setText("");
                        txtlocattion.setText("");

                    }
                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT).show();

                }


            }
        });*/

        dataArrayList = new ArrayList<>();

        customAdapter = new RestaurantApter(RestaurantListActivity.this, dataArrayList);

        listView.setAdapter(customAdapter);


        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                RestaurantData datam = dataSnapshot.getValue(RestaurantData.class);

                dataArrayList.add(datam);

                customAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                final View v = inflater1.from(getApplicationContext()).inflate(R.layout.restaurant_alert, null);
                temp = i;

                final EditText updtname, updtage , updtlocation;

                updtname = (EditText) v.findViewById(R.id.updtname);
                updtlocation = (EditText) v.findViewById(R.id.updtlocation);
                updtage = (EditText) v.findViewById(R.id.updtage);


                final AlertDialog.Builder builder  = new AlertDialog.Builder(RestaurantListActivity.this).setView(v);
                final AlertDialog alert = builder.create();

                v.findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        RestaurantData tempData = new RestaurantData(dataArrayList.get(temp).getKey(), updtname.getText().toString().trim(),

                                Integer.parseInt(updtage.getText().toString().trim())  , updtlocation.getText().toString().trim());

                        databaseReference.child(dataArrayList.get(temp).getKey()).setValue(tempData);

                        dataArrayList.remove(temp);

                        dataArrayList.add(temp,tempData);

                        customAdapter.notifyDataSetChanged();
                    }
                });

                v.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(temp == -1){

                            Toast.makeText(getApplicationContext(), "There is no data to delete", Toast.LENGTH_SHORT).show();

                        }else {

                            databaseReference.child(dataArrayList.get(temp).getKey()).removeValue();

                            dataArrayList.remove(temp);

                            customAdapter.notifyDataSetChanged();

                            alert.cancel();

                            temp = -1;
                        }
                    }
                });



                updtname.setText(dataArrayList.get(temp).getName());
                updtlocation.setText(dataArrayList.get(temp).getLocation());
                updtage.setText("" + dataArrayList.get(temp).getAge());



                try {


                    alert.show();

                } catch (Exception e) {

                    Log.d("show", "onItemClick: " + e);

                }




                return;


            }
        });

        txtsearch = (EditText) findViewById(R.id.search);

        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = txtsearch.getText().toString().trim();

                databaseReference.orderByChild("name").equalTo(name).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        ++count;



                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                            data = dataSnapshot1.getValue(RestaurantData.class);
                            dataArrayList.clear();
                            dataArrayList.add(data);
                            Log.d("log", "onDataChange: "+dataSnapshot1.child("name").getValue());

                        }


                        func();






                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });








            }
        });

        realtimeUpdate();
    }

    public void realtimeUpdate(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataArrayList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){

                    data = dataSnapshot1.getValue(RestaurantData.class);

                    dataArrayList.add(data);

                }


                customAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void func(){

        if(count!=0){

            customAdapter = new RestaurantApter(getApplicationContext(),dataArrayList);

            listView.setAdapter(customAdapter);

        }else {

            Toast.makeText(getApplicationContext(), "There is no data to show", Toast.LENGTH_SHORT).show();
            listView.setVisibility(View.GONE);
        }

    }
}












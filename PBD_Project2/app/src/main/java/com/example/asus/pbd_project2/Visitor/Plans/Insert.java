package com.example.asus.pbd_project2.Visitor.Plans;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.pbd_project2.Classes.coloriesClass;
import com.example.asus.pbd_project2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Insert extends AppCompatActivity {

    EditText classif , name , colories ;
    String classvalue , nameValue , coloriesValue ;
    Button save ;
    DatabaseReference db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        classif = (EditText) findViewById(R.id.classification);
        name = (EditText) findViewById(R.id.name);
        colories = (EditText) findViewById(R.id.coloriesvalue);




        save = (Button) findViewById(R.id.savebtn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                classvalue = classif.getText().toString();
                nameValue = name.getText().toString();
                coloriesValue = colories.getText().toString();

               try{

                   if(classvalue.equals("") || nameValue.equals("") ||coloriesValue.equals("")){
                       Toast.makeText(Insert.this, "Please Complete Your Data", Toast.LENGTH_SHORT).show();
                   }else {
                       db = FirebaseDatabase.getInstance().getReference("Colories");
                       String id = db.push().getKey();
                       coloriesClass object = new coloriesClass(id, classvalue, nameValue, coloriesValue);
                     /*  object.setClassification(classvalue);
                       object.setCid(id);
                       object.setCname(nameValue);
                       object.setColoriesvalue(coloriesValue);
                     */
                       db.push().setValue(object);
                    //   classif.setText("");
                       name.setText("");
                       colories.setText("");
                       Toast.makeText(Insert.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
                   }
               }catch (Exception ex){
                   Toast.makeText(Insert.this, ""+ex, Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}

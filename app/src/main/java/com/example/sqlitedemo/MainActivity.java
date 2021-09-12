package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper myDatabaseHelper;
    private EditText name, age, gender;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nameEditId);
        age = findViewById(R.id.ageEditId);
        gender = findViewById(R.id.genderEditId);

        add = findViewById(R.id.addbtn);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Sn = name.getText().toString();
                String Sa = age.getText().toString();
                String Sg = gender.getText().toString();

                long rowId = myDatabaseHelper.insertData(Sn, Sa, Sg);
                if(rowId==-1){
                    Toast.makeText(getApplicationContext(), "Decline", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Successful "+rowId, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
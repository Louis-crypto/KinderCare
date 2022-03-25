package com.moringaschool.kindercare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonViewAll, buttonAdd;
    EditText vaccineName, NoOfDoses, vaccineDescription, ageLimit, vaccineID;
    Switch availableVaccine;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        vaccineName = findViewById(R.id.vaccineName);
        vaccineDescription = findViewById(R.id.vaccineDescription);
        ageLimit = findViewById(R.id.ageLimit);
        vaccineID = findViewById(R.id.vaccineID);
        NoOfDoses = findViewById(R.id.NoOfDoses);
        availableVaccine = findViewById(R.id.availableVaccine);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                VaccineModel vaccineModel;
                try {
                    vaccineModel = new VaccineModel(-1, vaccineName.getText().toString(), vaccineDescription.getText().toString(), Integer.parseInt(NoOfDoses.getText().toString()), ageLimit.getText().toString(), availableVaccine.isChecked() );
                    Toast.makeText(MainActivity.this, vaccineModel.toString(), Toast.LENGTH_LONG).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Makosa imefanyika", Toast.LENGTH_LONG).show();
                    vaccineModel = new VaccineModel(-1, "error", "error", 0, "error", false);
                }

                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.addOne(vaccineModel);
                Toast.makeText(MainActivity.this, "Succeess " + success, Toast.LENGTH_SHORT).show();
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ViewAllVaccinesActivity.class));
            }
        });

    }

}
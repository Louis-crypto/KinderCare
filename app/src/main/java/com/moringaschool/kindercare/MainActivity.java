package com.moringaschool.kindercare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonViewAll, buttonAdd;
    EditText babyName, babyAge;
    Switch availableVaccine;
    ListView listViewVaccines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        babyName = findViewById(R.id.babyName);
        babyAge = findViewById(R.id.babyAge);
        availableVaccine = findViewById(R.id.availableVaccine);
        listViewVaccines = findViewById(R.id.listViewVaccines);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "added", Toast.LENGTH_SHORT).show();
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "removed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
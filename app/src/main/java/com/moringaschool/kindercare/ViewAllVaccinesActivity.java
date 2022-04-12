package com.moringaschool.kindercare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ViewAllVaccinesActivity extends AppCompatActivity {

    ListView listView;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_vaccines);

        listView = findViewById(R.id.listViewVaccines);
        databaseHelper = new DatabaseHelper(this);

        getSupportActionBar().setTitle(Html.fromHtml("<font color =\"#096363\">" + getString(R.string.app_name) + "</font>"));

    List<VaccineModel> vaccineList = databaseHelper.getAllVaccines();

        VaccineListAdapter vaccineListAdapter = new VaccineListAdapter(this, R.layout.vaccine_list_item, vaccineList);
        listView.setAdapter(vaccineListAdapter);

        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewAllVaccinesActivity.this, BookVaccineActivity.class);
                startActivity(intent);
            }
        });
    }


}
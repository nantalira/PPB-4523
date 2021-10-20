package com.example.project4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    ListView ListView;
    public String bhs_program[] = {"Prolog","C+","Pascal","Cobol","Perl","Algol L","Java","PHP","Phyton"};
    Spinner combo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView = (ListView) findViewById(R.id.listData);
        combo = (Spinner) findViewById(R.id.combodata);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,bhs_program);
        ListView.setAdapter(adapter);
        combo.setAdapter(adapter);
    }
}
package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Home3 extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[], s4[];
    int images[] = {R.drawable.carabikang, R.drawable.sotong, R.drawable.sate2, R.drawable.mie3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.menuMakanan3);
        s2 = getResources().getStringArray(R.array.deskripsiMakanan3);
        s3 = getResources().getStringArray(R.array.hargaMakanan3);
        s4 = getResources().getStringArray(R.array.ratingMakanan3);


        AdapterQ adapterQ = new AdapterQ(this, s1, s2, s3, s4, images);
        recyclerView.setAdapter(adapterQ);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[], s4[];
    int images[] = {R.drawable.megono, R.drawable.lontong, R.drawable.mie, R.drawable.burger, R.drawable.sate, R.drawable.satejagung};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.menuMakanan);
        s2 = getResources().getStringArray(R.array.deskripsiMakanan);
        s3 = getResources().getStringArray(R.array.hargaMakanan);
        s4 = getResources().getStringArray(R.array.ratingMakanan);


        AdapterQ adapterQ = new AdapterQ(this, s1, s2, s3, s4, images);
        recyclerView.setAdapter(adapterQ);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
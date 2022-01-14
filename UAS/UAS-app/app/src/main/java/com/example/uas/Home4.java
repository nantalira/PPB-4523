package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Home4 extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[], s4[];
    int images[] = {R.drawable.megono, R.drawable.lontong, R.drawable.serabi, R.drawable.soto, R.drawable.carabikang, R.drawable.sotong};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home4);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.menuMakanan4);
        s2 = getResources().getStringArray(R.array.deskripsiMakanan4);
        s3 = getResources().getStringArray(R.array.hargaMakanan4);
        s4 = getResources().getStringArray(R.array.ratingMakanan4);


        AdapterQ adapterQ = new AdapterQ(this, s1, s2, s3, s4, images);
        recyclerView.setAdapter(adapterQ);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
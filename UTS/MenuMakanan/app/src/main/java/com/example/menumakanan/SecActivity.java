package com.example.menumakanan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mainImageView;
    TextView name, description, price;
    Button order;

    String data1, data2, data3;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        mainImageView = findViewById(R.id.fotoMakanan);
        name = findViewById(R.id.namaMakanan);
        description = findViewById(R.id.deskripsiMakanan);
        price = findViewById(R.id.hargaMakanan);
        order = findViewById(R.id.buttonOrder);
        order.setOnClickListener(this);

        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("imageQ") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data2")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            images = getIntent().getIntExtra("imageQ", 1);

        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData() {
        name.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(images);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Warunge sek tutup pak", Toast.LENGTH_SHORT).show();
    }
}
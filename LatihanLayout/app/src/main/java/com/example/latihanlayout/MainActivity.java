package com.example.latihanlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView angkaCounter;
    int angka = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angkaCounter=findViewById(R.id.counter);
    }

    public void toastClick(View view) {
        Toast.makeText(this, "Ini adalah Toast", Toast.LENGTH_SHORT).show();
    }

    public void tmbCounter(View view) {
        angka += 1;
        angkaCounter.setText(Integer.toString(angka));
    }
}
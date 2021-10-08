package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Kalkulator extends AppCompatActivity {
    EditText angka1, angka2;
    TextView hasilnya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        angka1 = (EditText) findViewById(R.id.angka1);
        angka2 = (EditText) findViewById(R.id.angka2);
        hasilnya = (TextView) findViewById(R.id.hasilHitung);
    }


    public void tambah(View view) {
        int a1  = Integer.parseInt(angka1.getText().toString());
        int a2  = Integer.parseInt(angka2.getText().toString());
        Integer hasil = a1 + a2;
        hasilnya.setText(hasil.toString());
    }

    public void kurang(View view) {
        int a1  = Integer.parseInt(angka1.getText().toString());
        int a2  = Integer.parseInt(angka2.getText().toString());
        Integer hasil = a1 - a2;
        hasilnya.setText(hasil.toString());
    }

    public void kali(View view) {
        int a1  = Integer.parseInt(angka1.getText().toString());
        int a2  = Integer.parseInt(angka2.getText().toString());
        Integer hasil = a1 * a2;
        hasilnya.setText(hasil.toString());
    }

    public void bagi(View view) {
        Double a1  = Double.parseDouble(angka1.getText().toString());
        Double a2  = Double.parseDouble(angka2.getText().toString());
        Double hasil = a1 / a2;
        hasilnya.setText(hasil.toString());
    }
}
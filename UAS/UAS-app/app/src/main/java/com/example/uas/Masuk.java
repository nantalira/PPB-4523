package com.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uas.Common.common;
import com.example.uas.Model.Account;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Masuk extends AppCompatActivity {
    EditText edtPhone, edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtPhone = (EditText) findViewById(R.id.edtPhone);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table_account = database.getReference("Account");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog mDialog = new ProgressDialog(Masuk.this);
                mDialog.setMessage("Tunggu bentar...");
                mDialog.show();

                table_account.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Check if user doesn't exist
                        if(snapshot.child(edtPhone.getText().toString()).exists()){
                            //Get User Info
                            mDialog.dismiss();
                            Account user = snapshot.child(edtPhone.getText().toString()).getValue(Account.class);
                            if(user.getPassword().equals(edtPassword.getText().toString())){
                                Intent homeIntent = new Intent(Masuk.this,Warung.class);
                                common.currentAccount = user;
                                startActivity(homeIntent);
                                finish();
                            }
                            else {
                                Toast.makeText(Masuk.this, "PASSWORD SALAH SOB", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            mDialog.dismiss();
                            Toast.makeText(Masuk.this, "Akun Ini Nggak ada", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}
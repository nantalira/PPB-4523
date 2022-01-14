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

import com.example.uas.Model.Account;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Daftar extends AppCompatActivity {

    EditText edtPhone, edtName, edtPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_daftar);
        edtName = (EditText) findViewById (R.id.edtName);
        edtPassword = (EditText) findViewById (R.id.edtPassword);
        edtPhone = (EditText) findViewById (R.id.edtPhone) ;
        btnSignUp = (Button) findViewById (R.id.btnSignUp) ;

        //Init Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table_account = database.getReference("Account");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog mDialog = new ProgressDialog(Daftar.this);
                mDialog.setMessage("Tunggu bentar...");
                mDialog.show();

                table_account.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Check if already user phone
                        if(snapshot.child(edtPhone.getText().toString()).exists ()) {
                            mDialog.dismiss ();
                            Toast.makeText(Daftar.this, "sudah ada nomer ini", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            mDialog.dismiss ();
                            Account account = new Account(edtName.getText().toString(),edtPassword.getText().toString());
                            table_account.child (edtPhone.getText ().toString ()).setValue (account);
                            Toast.makeText(Daftar.this, "BERHASIL GAN", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(Daftar.this,MainActivity.class);
                            startActivity(mainIntent);
                            finish ();
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
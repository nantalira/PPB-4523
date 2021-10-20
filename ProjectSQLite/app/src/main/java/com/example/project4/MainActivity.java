package com.example.project4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, classes, role, speciality, difficulty;
    Button insert, edit, delete, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        classes = findViewById(R.id.classes);
        role = findViewById(R.id.role);
        speciality = findViewById(R.id.speciality);
        difficulty = findViewById(R.id.difficulty);


        insert = findViewById(R.id.btnInsert);
        edit = findViewById(R.id.btnEdit);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String classesTXT = classes.getText().toString();
                String roleTXT = role.getText().toString();
                String specialityTXT = speciality.getText().toString();
                String difficultyTXT = difficulty.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, classesTXT, roleTXT, specialityTXT, difficultyTXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "new entry inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "new entry not inserted", Toast.LENGTH_SHORT).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String classesTXT = classes.getText().toString();
                String roleTXT = role.getText().toString();
                String specialityTXT = speciality.getText().toString();
                String difficultyTXT = difficulty.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, classesTXT, roleTXT, specialityTXT, difficultyTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "entry updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "new entry not updated", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();

                Boolean checkupdatedata = DB.deletedata(nameTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "entry deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "entry not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "no entry exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Class :"+res.getString(1)+"\n");
                    buffer.append("Role :"+res.getString(2)+"\n");
                    buffer.append("Speciality :"+res.getString(3)+"\n");
                    buffer.append("Difficulty :"+res.getString(4)+"\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}
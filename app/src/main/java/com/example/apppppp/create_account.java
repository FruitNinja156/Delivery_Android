package com.example.apppppp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ThemedSpinnerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.*;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class create_account extends AppCompatActivity {
Button button;
TextInputEditText phnoEditText, nameEditText, lnameEditText, emailEditText, passwEditText, userEditText;
ConstraintLayout constraintLayout;
SQLiteDatabase db;
DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        button = findViewById(R.id.btn_signup);
        phnoEditText = findViewById(R.id.phnoEdit);
         nameEditText = findViewById(R.id.name_edit);
         lnameEditText = findViewById(R.id.lnameEdit);
        emailEditText = findViewById(R.id.emailEdit);
         passwEditText = findViewById(R.id.passwEdit);
         userEditText = findViewById(R.id.userEdit);
         dbHelper= new DBHelper(this);

        ConstraintLayout constraintLayout = findViewById(R.id.mainlayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                    db.execSQL("INSERT INTO DoorDash(name, lname, phno,email, passw, username)VALUES " +
//                            "('"+nameEditText.getText()+"','"+lnameEditText.getText()+"','"+phnoEditText.getText()+"','"+emailEditText.getText()+"','"+passwEditText.getText()+"','"+userEditText.getText()+"');");
//                    Cursor c = db.rawQuery("SELECT * FROM DoorDash", null);
//                    StringBuffer buffer = new StringBuffer();
//                    while (c.moveToNext()) {
//                        buffer.append(c.getString(1));
//                        buffer.append(c.getString(2));
//                        buffer.append(c.getString(3));
//                    }
//                    Toast.makeText(getApplicationContext(),  buffer.toString(), Toast.LENGTH_SHORT).show();

                    String name = nameEditText.getText().toString();
                    String lname = lnameEditText.getText().toString();
                    //int phno = Integer.parseInt(phnoEditText.getText().toString());
                String phno =phnoEditText.getText().toString();
                String email = emailEditText.getText().toString();
                    String passw = passwEditText.getText().toString();
                    String username = userEditText.getText().toString();
                    Boolean insert = dbHelper.insertData(name,lname,phno,email ,passw, username);
                    Boolean checkUsername = dbHelper.checkUser(username);
                    if (name.equals("") || lname.equals("")|| phno.equals("")||email.equals("") || passw.equals("") || username.equals("")){
                        Toast.makeText(getApplicationContext(), "Please Insert Your Data!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (insert) {
                            Toast.makeText(getApplicationContext(), "Account Created," + name + " Sign In to Continue!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(create_account.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Error while trying to create account!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        });
    }

}
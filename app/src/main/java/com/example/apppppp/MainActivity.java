package com.example.apppppp;

import static java.lang.Integer.valueOf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apppppp.ui.gallery.GalleryFragment;
import com.example.apppppp.ui.home.HomeFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
TextView textView;
TextInputEditText textInputEditText, textInputEditText1;
Button button;
ConstraintLayout constraintLayout;
DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper =new DBHelper(this);
        textView=findViewById(R.id.sign_up);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create_account();
            }
        });
        button =findViewById(R.id.btn_signin);
        textInputEditText=findViewById(R.id.txtUser);
        textInputEditText1=findViewById(R.id.txtPassw);
        constraintLayout = findViewById(R.id.mainActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = textInputEditText.getText().toString();
                String pass = textInputEditText1.getText().toString();
                Boolean checkuserpass= dbHelper.checkUserandPass(user, pass);

//                if (textInputEditText1.getText().toString().equals("admin")&& textInputEditText.getText().toString().equals("admin")){
                if (checkuserpass){
                    /* Toast.makeText(getApplicationContext(), "Welcome, " + textInputEditText.getText() +"!!",Toast.LENGTH_SHORT).show(); */
                    Snackbar.make(constraintLayout, "Welcome, " + textInputEditText.getText().toString(), Snackbar.LENGTH_LONG).show();
                open_home();
                }
                else if (textInputEditText.getText().toString().isEmpty() || textInputEditText1.getText().toString().isEmpty()){
                   Toast.makeText(getApplicationContext(), "No Input Detected!", Toast.LENGTH_SHORT).show();
//                    Snackbar.make(constraintLayout, "No Input Detected!", Snackbar.LENGTH_LONG).show();
                }
                else{
//                    Toast.makeText(getApplicationContext(), "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                    Snackbar.make(constraintLayout, "Incorrect Usernmae or Password!", Snackbar.LENGTH_LONG)
                            .setAction("Clear", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    textInputEditText.setText("");
                                    textInputEditText1.setText("");
                                }
                            }).show();
                }
            }
        });
    }
    public void create_account(){
        Intent intent = new Intent(this,create_account.class);
        startActivity(intent);
    }
    public void open_home(){
        Intent intent = new Intent(this, NavDrawer.class);
        startActivity(intent);
    }

}
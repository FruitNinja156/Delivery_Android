package com.example.apppppp;

import static android.content.Intent.ACTION_VIEW;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.apppppp.R;

public class Locate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locate);
        Intent intent =  new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:9.00.28.0,38.48.18.2"));
        startActivity(intent);
    }
}

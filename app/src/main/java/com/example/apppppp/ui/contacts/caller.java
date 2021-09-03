package com.example.apppppp.ui.contacts;

import static android.content.Intent.ACTION_DIAL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.apppppp.R;

public class caller extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);
        Intent intent = new Intent(ACTION_DIAL);
        intent.setData(Uri.parse("tel:0911111111"));
        startActivity(intent);
    }
}
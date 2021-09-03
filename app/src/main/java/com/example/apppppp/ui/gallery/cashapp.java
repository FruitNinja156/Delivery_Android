package com.example.apppppp.ui.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.apppppp.R;

public class cashapp extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashapp);
        webView =(WebView)findViewById(R.id.cashapp_web);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://ww.cashapp.com/pay");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
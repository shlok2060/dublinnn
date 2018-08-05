package com.example.android.dublin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        webView = (WebView)findViewById(R.id.webview);
        String url = "https://www.visitdublin.com/";
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}

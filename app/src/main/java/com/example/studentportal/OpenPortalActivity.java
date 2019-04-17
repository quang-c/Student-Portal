package com.example.studentportal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class OpenPortalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_portal);

        // get url
        Portal portal = getIntent().getParcelableExtra(MainActivity.WEB_PAGE);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl(portal.getUrl());
        webView.setWebViewClient(new WebViewController());
    }

    public class WebViewController extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

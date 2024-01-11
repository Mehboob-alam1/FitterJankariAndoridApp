package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityFlangeqnaBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;

public class flangeqna extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityFlangeqnaBinding binding;
    private String url = "https://www.technicalyunique.com/1516/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlangeqnaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.flangeqnaWebview.setWebViewClient(new MyBrowser());
        binding.flangeqnaWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.flangeqnaWebview.getSettings().setJavaScriptEnabled(true);
        binding.flangeqnaWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.flangeqnaWebview.loadUrl(url);

        progressBar=findViewById(R.id.progressbar);

    }

    private class MyBrowser extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);


            return true;
        }
    }
}

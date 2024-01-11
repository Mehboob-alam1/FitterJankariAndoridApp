package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityUsesofsincostanBinding;

public class usesofsincostan extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityUsesofsincostanBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/12/25/uses-of-sin-cos-tan/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsesofsincostanBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.usesofsincostanWebview.setWebViewClient(new MyBrowser());
        binding.usesofsincostanWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.usesofsincostanWebview.getSettings().setJavaScriptEnabled(true);
        binding.usesofsincostanWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.usesofsincostanWebview.loadUrl(url);

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
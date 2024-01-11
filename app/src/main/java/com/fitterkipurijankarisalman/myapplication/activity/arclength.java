package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityArclengthBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;

public class arclength extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityArclengthBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/07/29/how-to-find-arc-length/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityArclengthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.arclengthWebview.setWebViewClient(new MyBrowser());
        binding.arclengthWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.arclengthWebview.getSettings().setJavaScriptEnabled(true);
        binding.arclengthWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.arclengthWebview.loadUrl(url);

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
package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fitterkipurijankarisalman.myapplication.databinding.ActivityTeebranchBinding;

public class teebranch extends AppCompatActivity {

    private ActivityTeebranchBinding binding;
    private String url = "https://www.technicalyunique.com/equal-tee-branch/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeebranchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.teebranchWebview.setWebViewClient(new MyBrowser());
        binding.teebranchWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.teebranchWebview.getSettings().setJavaScriptEnabled(true);
        binding.teebranchWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.teebranchWebview.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityArclengthtochordlengthBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityChordlengthBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityChordtoarclengthBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;

public class chordtoarclength extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityChordtoarclengthBinding binding;
    private String url = "https://fitterkipurijankari.com/2022/11/07/chord-length-to-arc-length/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChordtoarclengthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.chordtoarclengthWebview.setWebViewClient(new MyBrowser());
        binding.chordtoarclengthWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.chordtoarclengthWebview.getSettings().setJavaScriptEnabled(true);
        binding.chordtoarclengthWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.chordtoarclengthWebview.loadUrl(url);

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

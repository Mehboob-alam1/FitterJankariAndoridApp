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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityNutboltkebaremejaneBinding;


public class nutboltkebaremejane extends AppCompatActivity {

    ProgressBar progressBar;
    private ActivityNutboltkebaremejaneBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/07/29/type-of-bolt/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNutboltkebaremejaneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nutboltkebaremejaneWebview.setWebViewClient(new MyBrowser());
        binding.nutboltkebaremejaneWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.nutboltkebaremejaneWebview.getSettings().setJavaScriptEnabled(true);
        binding.nutboltkebaremejaneWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.nutboltkebaremejaneWebview.loadUrl(url);

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
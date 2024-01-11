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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityStructurefabricationdrawingBinding;

public class structurefabricationdrawing extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityStructurefabricationdrawingBinding binding;
    private String url = "https://fitterkipurijankari.com/2021/01/31/1942/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStructurefabricationdrawingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.structurefabricationdrawingWebview.setWebViewClient(new MyBrowser());
        binding.structurefabricationdrawingWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.structurefabricationdrawingWebview.getSettings().setJavaScriptEnabled(true);
        binding.structurefabricationdrawingWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.structurefabricationdrawingWebview.loadUrl(url);

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

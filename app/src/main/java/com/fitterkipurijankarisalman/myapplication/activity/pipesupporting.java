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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPipesupportingBinding;

public class pipesupporting extends AppCompatActivity {

    ProgressBar progressbar;

    private ActivityPipesupportingBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/08/12/type-of-pipe-support-fitterkipurijankari/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPipesupportingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.pipesupportingWebview.setWebViewClient(new MyBrowser());
        binding.pipesupportingWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.pipesupportingWebview.getSettings().setJavaScriptEnabled(true);
        binding.pipesupportingWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.pipesupportingWebview.loadUrl(url);

        progressbar =findViewById(R.id.progressbar);
    }

    private class MyBrowser extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressbar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            progressbar.setVisibility(View.GONE);

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);


            return true;
        }
    }
}

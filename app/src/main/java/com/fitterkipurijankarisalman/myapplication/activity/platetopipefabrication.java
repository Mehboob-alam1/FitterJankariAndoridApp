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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPlatetopipefabricationBinding;

public class platetopipefabrication extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityPlatetopipefabricationBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/10/16/plate-to-pipe-fabrication/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlatetopipefabricationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.platetopipefabricationWebview.setWebViewClient(new MyBrowser());
        binding.platetopipefabricationWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.platetopipefabricationWebview.getSettings().setJavaScriptEnabled(true);
        binding.platetopipefabricationWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.platetopipefabricationWebview.loadUrl(url);
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

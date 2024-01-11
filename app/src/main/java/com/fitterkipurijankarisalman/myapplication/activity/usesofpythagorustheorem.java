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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityTypesofweldoletBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityUsesofpythagorustheoremBinding;

public class usesofpythagorustheorem extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityUsesofpythagorustheoremBinding binding;
    private String url = "https://fitterkipurijankari.com/2021/02/07/types-of-weldolet/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsesofpythagorustheoremBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.usesofpythagorustheoremWebview.setWebViewClient(new MyBrowser());
        binding.usesofpythagorustheoremWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.usesofpythagorustheoremWebview.getSettings().setJavaScriptEnabled(true);
        binding.usesofpythagorustheoremWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.usesofpythagorustheoremWebview.loadUrl(url);

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

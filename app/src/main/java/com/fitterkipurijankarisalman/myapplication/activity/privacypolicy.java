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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPrivacypolicyBinding;

public class privacypolicy extends AppCompatActivity {

    ProgressBar progressbar;

    private ActivityPrivacypolicyBinding binding;
    private String url = "https://fitterkipurijankari.com/2022/11/07/privacy-policy/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrivacypolicyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.privacypolicyWebview.setWebViewClient(new MyBrowser());
        binding.privacypolicyWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.privacypolicyWebview.getSettings().setJavaScriptEnabled(true);
        binding.privacypolicyWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.privacypolicyWebview.loadUrl(url);

        progressbar=findViewById(R.id.progressbar);

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

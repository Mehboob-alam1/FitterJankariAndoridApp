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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityRightangleformulaBinding;

public class rightangleformula extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityRightangleformulaBinding binding;
    private String url = "https://www.technicalyunique.com/plate-ka-right-angle-kaise-nilkale/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRightangleformulaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rightangleformulaWebview.setWebViewClient(new MyBrowser());
        binding.rightangleformulaWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.rightangleformulaWebview.getSettings().setJavaScriptEnabled(true);
        binding.rightangleformulaWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.rightangleformulaWebview.loadUrl(url);

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

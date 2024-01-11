package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityImportantshortcutBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;

public class importantshortcut extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityImportantshortcutBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/07/29/important-shortcut-for-fitter-and-fabricator/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImportantshortcutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.importantshortcutWebview.setWebViewClient(new MyBrowser());
        binding.importantshortcutWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.importantshortcutWebview.getSettings().setJavaScriptEnabled(true);
        binding.importantshortcutWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.importantshortcutWebview.loadUrl(url);

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
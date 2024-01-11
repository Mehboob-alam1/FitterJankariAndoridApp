package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityFitterkeliyehandtoolsBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityImportantmeasurementBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;

public class fitterkeliyehandtools extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityFitterkeliyehandtoolsBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/07/29/fitter-ke-liye-jaruri-tools/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFitterkeliyehandtoolsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fitterkeliyehandtoolsWebview.setWebViewClient(new MyBrowser());
        binding.fitterkeliyehandtoolsWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.fitterkeliyehandtoolsWebview.getSettings().setJavaScriptEnabled(true);
        binding.fitterkeliyehandtoolsWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.fitterkeliyehandtoolsWebview.loadUrl(url);

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

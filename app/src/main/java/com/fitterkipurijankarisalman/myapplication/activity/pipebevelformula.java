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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPipebevelformulaBinding;

public class pipebevelformula extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityPipebevelformulaBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/07/29/pipe-bevel-formula/#:~:text=%E0%A4%AA%E0%A4%BE%E0%A4%87%E0%A4%AA%20%E0%A4%AC%E0%A5%87%E0%A4%B5%E0%A4%B2%E0%A4%BF%E0%A4%82%E0%A4%97%20%E0%A4%B5%E0%A4%B9%20%E0%A4%AA%E0%A5%8D%E0%A4%B0%E0%A4%95%E0%A5%8D%E0%A4%B0%E0%A4%BF%E0%A4%AF%E0%A4%BE%20%E0%A4%B9%E0%A5%88,%E0%A4%89%E0%A4%A4%E0%A5%8D%E0%A4%AA%E0%A4%BE%E0%A4%A6%E0%A4%BF%E0%A4%A4%20%E0%A4%95%E0%A4%BF%E0%A4%AF%E0%A4%BE%20%E0%A4%9C%E0%A4%BE%20%E0%A4%B8%E0%A4%95%E0%A4%A4%E0%A4%BE%20%E0%A4%B9%E0%A5%88%E0%A5%A4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPipebevelformulaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.pipebevelformulaWebview.setWebViewClient(new MyBrowser());
        binding.pipebevelformulaWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.pipebevelformulaWebview.getSettings().setJavaScriptEnabled(true);
        binding.pipebevelformulaWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.pipebevelformulaWebview.loadUrl(url);

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

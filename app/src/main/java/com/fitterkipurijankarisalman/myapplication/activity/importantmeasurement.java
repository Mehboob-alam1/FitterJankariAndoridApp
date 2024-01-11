package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fitterkipurijankarisalman.myapplication.databinding.ActivityImportantmeasurementBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;

public class importantmeasurement extends AppCompatActivity {

    private ActivityImportantmeasurementBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/07/29/important-measurment-for-fitter-and-fabricator/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImportantmeasurementBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.importantmeasurementWebview.setWebViewClient(new MyBrowser());
        binding.importantmeasurementWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.importantmeasurementWebview.getSettings().setJavaScriptEnabled(true);
        binding.importantmeasurementWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.importantmeasurementWebview.loadUrl(url);
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
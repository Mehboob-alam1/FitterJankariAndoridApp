package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityChannelmitercuttinganydegreeBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityFitterkeliyehandtoolsBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityImportantmeasurementBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityInterviewqnaBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityIsometricdrawingkipahchanBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityRightangletrickBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivitySafetytoolsBinding;

public class channelmitercuttinganydegree extends AppCompatActivity {

    ProgressBar progressBar;

    private ActivityChannelmitercuttinganydegreeBinding binding;
    private String url = "https://fitterkipurijankari.com/2020/07/29/channel-miter-cutting/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChannelmitercuttinganydegreeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.channelmitercuttinganydegreeWebview.setWebViewClient(new MyBrowser());
        binding.channelmitercuttinganydegreeWebview.getSettings().setLoadsImagesAutomatically(true);
        binding.channelmitercuttinganydegreeWebview.getSettings().setJavaScriptEnabled(true);
        binding.channelmitercuttinganydegreeWebview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        binding.channelmitercuttinganydegreeWebview.loadUrl(url);

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
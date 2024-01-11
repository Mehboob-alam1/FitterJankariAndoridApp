package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;


import com.fitterkipurijankarisalman.myapplication.SubscriptionActivity;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityWpbunitweightBinding;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.fitterkipurijankarisalman.myapplication.R;


public class wpbunitweight extends AppCompatActivity {

    private ActivityWpbunitweightBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        binding = ActivityWpbunitweightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PDFView pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("wpb_unit_weight.pdf").load();



        loadBannerAd();
    }

    private void loadBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.wpbunitweightAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        binding.wpbunitweightAdView.loadAd(adRequest);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_no_ads) {
            startActivity(new Intent(
                    getBaseContext(), SubscriptionActivity.class
            ));


            return false;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }}

package com.fitterkipurijankarisalman.myapplication.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHowtomakeelbowBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHowtomakeybranchBinding;


public class howtomakeybranch extends AppCompatActivity {

    private ActivityHowtomakeybranchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHowtomakeybranchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadBannerAd();
    }

    private void loadBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.howtomakeybranchAdView.setAdListener(new AdListener() {
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

        binding.howtomakeybranchAdView.loadAd(adRequest);
    }
}
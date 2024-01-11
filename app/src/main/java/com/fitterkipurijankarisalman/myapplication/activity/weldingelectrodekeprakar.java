package com.fitterkipurijankarisalman.myapplication.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fitterkipurijankarisalman.myapplication.databinding.ActivityWeldingelectrodekeprakarBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHowtomakeelbowBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPipeweightkgpermeterBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityWeldingBinding;


public class weldingelectrodekeprakar extends AppCompatActivity {

    private ActivityWeldingelectrodekeprakarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeldingelectrodekeprakarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadBannerAd();
    }

    private void loadBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.weldingelectrodekeprakarAdView.setAdListener(new AdListener() {
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

        binding.weldingelectrodekeprakarAdView.loadAd(adRequest);
    }
}
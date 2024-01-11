package com.fitterkipurijankarisalman.myapplication.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fitterkipurijankarisalman.myapplication.databinding.ActivityBigdiametermiterformulaBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityConekadegreekaisenikaleBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityElbowformulaBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHowtomakeelbowBinding;


public class bigdiametermiterformula extends AppCompatActivity {

    private ActivityBigdiametermiterformulaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBigdiametermiterformulaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadBannerAd();
    }

    private void loadBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.bigdiametermiterformulaAdView.setAdListener(new AdListener() {
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

        binding.bigdiametermiterformulaAdView.loadAd(adRequest);
    }
}
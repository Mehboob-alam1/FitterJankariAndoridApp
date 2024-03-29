package com.fitterkipurijankarisalman.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.SubscriptionActivity;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityDegreemeflangefitupkaisekareBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityElbowkitneprakarkehotehaiBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityElbowkokisibhidegreemecuttingBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityFourtyfivedegreeelbowcenterkaisenikaleBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityFourtyfivedegreeelbowkaisebanayeBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityFourtyfivedegreekaelbowkaisefitupkareBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityTypesofflangeclassesBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityAnydegreeelbowcuttingBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityFlangemakingformulaBinding;


public class typesofflangeclasses extends AppCompatActivity {

    private ActivityTypesofflangeclassesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTypesofflangeclassesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadBannerAd();
    }

    private void loadBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.typesofflangeclassesAdView.setAdListener(new AdListener() {
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

        binding.typesofflangeclassesAdView.loadAd(adRequest);
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

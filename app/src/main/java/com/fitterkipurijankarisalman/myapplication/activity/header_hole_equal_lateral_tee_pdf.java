package com.fitterkipurijankarisalman.myapplication.activity;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import com.fitterkipurijankarisalman.myapplication.Config;
import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHeaderHoleEqualLateralTeePdfBinding;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;



public class header_hole_equal_lateral_tee_pdf extends AppCompatActivity implements View.OnClickListener {

    private ActivityHeaderHoleEqualLateralTeePdfBinding binding;
    private Dialog loadingDialog;

    private InterstitialAd mInterstitialAd;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityHeaderHoleEqualLateralTeePdfBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        if (!Config.isPaidUser) {
            loadBannerAd();
        }

        PDFView pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("equal_lateral_tee_header_hole_formula.pdf").load();

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);
        binding.button1.setOnClickListener(this);
    }

    private void loadBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.equallateralteebranchpdfAdView.setAdListener(new AdListener() {
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
        binding.equallateralteebranchpdfAdView.loadAd(adRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingInterstitialAd();
                break;
            case R.id.button2:
                flag = 2;
                startLoadingInterstitialAd();
                break;

            default:
                break;
        }
    }

    private void startLoadingInterstitialAd() {
        if (!Config.isPaidUser) {
            loadingDialog.show();
            loadInterstitialAd();
        } else {
            startRequiredActivity();
        }

    }

    private void startRequiredActivity() {
        if (flag == 1) {
            Intent header_hole_equal_lateral_tee_video = new Intent(this, header_hole_equal_lateral_tee_video.class);
            startActivity(header_hole_equal_lateral_tee_video);
        } else if (flag == 2) {
            Intent eccentricreducerpdf = new Intent(this, eccentricreducerpdf.class);
            startActivity(eccentricreducerpdf);
        }
    }

    private void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, getResources().getString(R.string.admob_interstitial_id_headerholeformula), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        loadingDialog.dismiss();
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                super.onAdClicked();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                startRequiredActivity();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                                super.onAdFailedToShowFullScreenContent(adError);
                                Toast.makeText(header_hole_equal_lateral_tee_pdf.this, "Ad failed to load full screen content", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                                mInterstitialAd = null;
                            }
                        });

                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(header_hole_equal_lateral_tee_pdf.this);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                        loadingDialog.dismiss();
                        startRequiredActivity();
                        Toast.makeText(header_hole_equal_lateral_tee_pdf.this, "Ad failed to load.", Toast.LENGTH_SHORT).show();
                    }
                });
    }






}

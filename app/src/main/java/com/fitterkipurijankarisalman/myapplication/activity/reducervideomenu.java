package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityReducervideomenuBinding;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;





public class reducervideomenu extends AppCompatActivity implements View.OnClickListener {

    private ActivityReducervideomenuBinding binding;
    private Dialog loadingDialog;

    private InterstitialAd mInterstitialAd;
    private RewardedAd mRewardedAd;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityReducervideomenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);
        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingRewardedAd();
                break;
            case R.id.button2:
                flag = 2;
                startLoadingRewardedAd();
                break;

            default:
                break;
        }
    }

    private void startLoadingInterstitialAd() {
        loadingDialog.show();
        loadInterstitialAd();
    }

    private void startLoadingRewardedAd() {
        loadingDialog.show();
        loadRewardedAd();
    }

    private void startRequiredActivity() {
        if (flag == 1) {
            Intent concentricreducermenu = new Intent(this, concentricreducermenu.class);
            startActivity(concentricreducermenu);
        } else if (flag == 2) {
            Intent eccentricreducermenu = new Intent(this, eccentricreducermenu.class);
            startActivity(eccentricreducermenu);
        }
    }

    private void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo), adRequest,
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
                                Toast.makeText(reducervideomenu.this, "Ad failed to load full screen content", Toast.LENGTH_SHORT).show();
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
                            mInterstitialAd.show(reducervideomenu.this);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                        loadingDialog.dismiss();
                        startRequiredActivity();
                        Toast.makeText(reducervideomenu.this, "Ad failed to load.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadRewardedAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, getResources().getString(R.string.admob_rewarded_id_platetoreducer),
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mRewardedAd = null;
                        loadingDialog.dismiss();
                        startRequiredActivity();
                        Toast.makeText(reducervideomenu.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        loadingDialog.dismiss();
                        mRewardedAd = rewardedAd;
                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
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
                            }

                            @Override
                            public void onAdImpression() {
                                super.onAdImpression();
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent();
                            }
                        });

                        if (mRewardedAd != null) {
                            Activity activityContext = reducervideomenu.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Toast.makeText(reducervideomenu.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            Toast.makeText(reducervideomenu.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
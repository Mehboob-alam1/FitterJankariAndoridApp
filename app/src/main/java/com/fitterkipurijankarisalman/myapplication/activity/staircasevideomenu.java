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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityStaircasevideomenuBinding;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class staircasevideomenu extends AppCompatActivity implements View.OnClickListener {

    private ActivityStaircasevideomenuBinding binding;
    private Dialog loadingDialog;

    private RewardedAd mRewardedAd;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityStaircasevideomenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);

        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
    }

    private void startLoadingRewardedAd(String rewardedId) {
        loadingDialog.show();
        loadRewardedAd(rewardedId);
    }


    private void startRequiredActivity() {
        if (flag == 1) {
            Intent staircasekaisebanaye = new Intent(this, staircasekaisebanaye.class);
            startActivity(staircasekaisebanaye);
        } else if (flag == 2) {
            Intent staircasekafittingvideo = new Intent(this, staircasekafittingvideo.class);
            startActivity(staircasekafittingvideo);

        } else if (flag == 3) {
            Intent staircaselayoutvideo = new Intent(this, staircaselayoutvideo.class);
            startActivity(staircaselayoutvideo);

        }
    }



    private void loadRewardedAd(String rewardedId) {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(this, rewardedId,
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mRewardedAd = null;
                        loadingDialog.dismiss();
                        startRequiredActivity();
                //        Toast.makeText(staircasevideomenu.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                            Activity activityContext = staircasevideomenu.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                //                    Toast.makeText(staircasevideomenu.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                //            Toast.makeText(staircasevideomenu.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_staircasekaisebanaye));
                break;
            case R.id.button2:
                flag = 2;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_staircasekafittingvideo));
                break;
            case R.id.button3:
                flag = 3;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_staircasekalayoutkaisekare));
                break;


            default:
                break;
        }
    }
}



package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityConcentricreducermenuBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHowtomakeflangeBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHowtomakeflangevideomenuBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityLiveworkingvideomenuBinding;
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


import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import java.util.ArrayList;

public class howtomakeflangevideomenu extends AppCompatActivity implements View.OnClickListener {

    private ActivityHowtomakeflangevideomenuBinding binding;
    private Dialog loadingDialog;

    private RewardedAd mRewardedAd;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityHowtomakeflangevideomenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);

        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);
    }

    private void startLoadingRewardedAd(String rewardedId) {
        loadingDialog.show();
        loadRewardedAd(rewardedId);
    }


    private void startRequiredActivity() {
        if (flag == 1) {
            Intent platekaflangekaisebanaye = new Intent(this, platekaflangekaisebanayevideo.class);
            startActivity(platekaflangekaisebanaye);
        } else if (flag == 2) {
            Intent sevenmeterdiaflange = new Intent(this, sevenmeterdiaflange.class);
            startActivity(sevenmeterdiaflange);
        } else if (flag == 3) {
            Intent flangefabricationlivevideo = new Intent(this, flangefabricationlivevideo.class);
            startActivity(flangefabricationlivevideo);
        } else if (flag == 4) {
            Intent typesofflangevideo = new Intent(this, typesofflangevideo.class);
            startActivity(typesofflangevideo);

        } else if (flag == 5) {
            Intent flangefitupanydegreevideo = new Intent(this, flangefitupanydegreevideo.class);
            startActivity(flangefitupanydegreevideo);

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
                //        Toast.makeText(howtomakeflangevideomenu.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                            Activity activityContext = howtomakeflangevideomenu.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                //                    Toast.makeText(howtomakeflangevideomenu.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                //            Toast.makeText(howtomakeflangevideomenu.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_platekaflangekaisebanaye));
                break;
            case R.id.button2:
                flag = 2;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_10meterdiaflange));
                break;
            case R.id.button3:
                flag = 3;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_flangefabricationlivevideo));
                break;
            case R.id.button4:
                flag = 4;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_typesofflangevideo));
                break;

            case R.id.button5:
                flag = 5;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_howtofitupflangeanydegree));
                break;

            default:
                break;
        }
    }
}



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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityLiveworkingvideomenuBinding;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityMiterbendvideomenuBinding;
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

public class miterbendvideomenu extends AppCompatActivity implements View.OnClickListener {

    private ActivityMiterbendvideomenuBinding binding;
    private Dialog loadingDialog;

    private RewardedAd mRewardedAd;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityMiterbendvideomenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);

        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
        binding.button5.setOnClickListener(this);


        binding.button6.setOnClickListener(this);
        binding.button7.setOnClickListener(this);
        binding.button8.setOnClickListener(this);
        binding.button9.setOnClickListener(this);
        binding.button10.setOnClickListener(this);

        binding.button11.setOnClickListener(this);
        binding.button12.setOnClickListener(this);
        binding.button13.setOnClickListener(this);
        binding.button14.setOnClickListener(this);



    }

    private void startLoadingRewardedAd(String rewardedId) {
        loadingDialog.show();
        loadRewardedAd(rewardedId);
    }


    private void startRequiredActivity() {
        if (flag == 1) {
            Intent konsasahihaivideo = new Intent(this, konsasahihaivideo.class);
            startActivity(konsasahihaivideo);
        } else if (flag == 2) {
            Intent ninetydegree2cutmiterbendvideo = new Intent(this, ninetydegree2cutmiterbendvideo.class);
            startActivity(ninetydegree2cutmiterbendvideo);
        } else if (flag == 3) {
            Intent ninetydegree3cutmiterbendvideo = new Intent(this, ninetydegree3cutmiterbendvideo.class);
            startActivity(ninetydegree3cutmiterbendvideo);
        } else if (flag == 4) {
            Intent fourtyfivedegree2cut = new Intent(this, fourtyfivedegree2cutmiterbend.class);
            startActivity(fourtyfivedegree2cut);

        } else if (flag == 5) {
            Intent fourtyfivedegree3cutmiterbend = new Intent(this, fourtyfivedegree3cutmiterbend.class);
            startActivity(fourtyfivedegree3cutmiterbend);

        } else if (flag == 6) {
            Intent fourtyfivedegree16clmiterbend = new Intent(this, fourtyfivedegree16clmiterbend.class);
            startActivity(fourtyfivedegree16clmiterbend);
        } else if (flag == 7) {
            Intent anydegreemitercuttingbestformulavideo = new Intent(this, anydegreemitercuttingbestformulavideo.class);
            startActivity(anydegreemitercuttingbestformulavideo);
        } else if (flag == 8) {
            Intent miterbend1800diavideo = new Intent(this, miterbend1800diavideo.class);
            startActivity(miterbend1800diavideo);

        } else if (flag == 9) {
            Intent miterbend2100diavideo = new Intent(this, miterbend2100diavideo.class);
            startActivity(miterbend2100diavideo);

        } else if (flag == 10) {
            Intent fourtyfivedegreesinglecutvideo = new Intent(this, fourtyfivedegreesinglecutvideo.class);
            startActivity(fourtyfivedegreesinglecutvideo);
        } else if (flag == 11) {
            Intent fourtyfivedegreesinglecutpart2video = new Intent(this, fourtyfivedegreesinglecutpart2video.class);
            startActivity(fourtyfivedegreesinglecutpart2video);
        } else if (flag == 12) {
            Intent platekamiterkaisebanayevideo = new Intent(this, platekamiterkaisebanayevideo.class);
            startActivity(platekamiterkaisebanayevideo);

        } else if (flag == 13) {
            Intent miterbend180degreevideo = new Intent(this, miterbend180degreevideo.class);
            startActivity(miterbend180degreevideo);

        } else if (flag == 14) {
            Intent dia1800miterbendvideo = new Intent(this, dia1800miterbendvideo.class);
            startActivity(dia1800miterbendvideo);

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
                //        Toast.makeText(miterbendvideomenu.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                            Activity activityContext = miterbendvideomenu.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                //                    Toast.makeText(miterbendvideomenu.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                //            Toast.makeText(miterbendvideomenu.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_90degreesinglecut));
                break;
            case R.id.button2:
                flag = 2;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_90degree2cut));
                break;
            case R.id.button3:
                flag = 3;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_90degree3cut));
                break;
            case R.id.button4:
                flag = 4;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_45degree1cut));
                break;

            case R.id.button5:
                flag = 5;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_45degree2cut));
                break;
            case R.id.button6:
                flag = 6;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_45degree3cut));
                break;
            case R.id.button7:
                flag = 7;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_anydegreemitercuttingbestformula));
                break;
            case R.id.button8:
                flag = 8;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_1800diamiterbend));
                break;

            case R.id.button9:
                flag = 9;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_2100diamiterbend));
                break;
            case R.id.button10:
                flag = 10;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_45degreesinglecut));
                break;
            case R.id.button11:
                flag = 11;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_45degreesinglecut2));
                break;
            case R.id.button12:
                flag = 12;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_platekamiterkaisebanaye));
                break;

            case R.id.button13:
                flag = 13;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_1800diamiterbend));
                break;
            case R.id.button14:
                flag = 14;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_howtodrawelbowradius));
                break;
            case R.id.button15:
                flag = 15;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_1800dia22_5degree));
                break;

            default:
                break;
        }
    }
}



package com.fitterkipurijankarisalman.myapplication.activity;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;


import android.app.Activity;

import android.app.Dialog;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;


import com.fitterkipurijankarisalman.myapplication.Config;
import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.SubscriptionActivity;


import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPipeweightkgpermeterBinding;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;



public class pipeweightkgpermeter extends AppCompatActivity implements View.OnClickListener {

    private ActivityPipeweightkgpermeterBinding binding;
    private Dialog loadingDialog;
    private RewardedAd mRewardedAd;
    private InterstitialAd mInterstitialAd;
    private int flag = 0;
    private Context mContext;



    //  @Override
    public void onAttach(Context context) {
        //          super.onAttach(context);
        mContext = context;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        binding = ActivityPipeweightkgpermeterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadBannerAd();
        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);
        binding.button1.setOnClickListener(this);

    }


    private void loadBannerAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        binding.pipeweightkgpermeterAdView.setAdListener(new AdListener() {
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

        binding.pipeweightkgpermeterAdView.loadAd(adRequest);
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
    }



    private void startLoadingInterstitialAd(String interstitialId) {
        loadingDialog.show();
        if (!Config.isPaidUser) {
            loadInterstitialAd(interstitialId);
        }
    }

    private void startLoadingRewardedAd(String rewardedId) {
        loadingDialog.show();
        if (!Config.isPaidUser) {
            loadRewardedAd(rewardedId);
        }
    }


    private void startRequiredActivity() {
        if (flag == 1) {
            Intent pipekavajankaisenikalevideo = new Intent(this, pipekavajankaisenikalevideo.class);
            startActivity(pipekavajankaisenikalevideo);
        }
        //       else if (flag == 2) {
        //           Intent elbowcentercalculation = new Intent(this, elbowcentercalculation.class);
        //           startActivity(elbowcentercalculation);
        //       }


//        }
    }
//


    private void loadInterstitialAd(String id) {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, id, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
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
                                //                       Toast.makeText(drawingshortcutt.this, "Ad failed to load full screen content", Toast.LENGTH_SHORT).show();
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
                            mInterstitialAd.show(pipeweightkgpermeter.this);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                        loadingDialog.dismiss();
                        startRequiredActivity();
                        //                Toast.makeText(drawingshortcutt.this, "Ad failed to load.", Toast.LENGTH_SHORT).show();
                    }
                });
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
                        //              Toast.makeText(drawingshortcutt.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                            Activity activityContext = pipeweightkgpermeter.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Toast.makeText(pipeweightkgpermeter.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            Toast.makeText(pipeweightkgpermeter.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipekavajankaisenikale));
                break;

            case R.id.button2:
                flag = 2;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;


            default:
                break;
        }
    }
}
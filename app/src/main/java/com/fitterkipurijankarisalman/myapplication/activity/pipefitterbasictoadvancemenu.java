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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPipefitterbasictoadvancemenuBinding;
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

public class pipefitterbasictoadvancemenu extends AppCompatActivity implements View.OnClickListener {

    private ActivityPipefitterbasictoadvancemenuBinding binding;
    private Dialog loadingDialog;

    private RewardedAd mRewardedAd;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityPipefitterbasictoadvancemenuBinding.inflate(getLayoutInflater());
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
        binding.button15.setOnClickListener(this);
        binding.button16.setOnClickListener(this);
        binding.button17.setOnClickListener(this);
        binding.button18.setOnClickListener(this);
        binding.button19.setOnClickListener(this);
        binding.button20.setOnClickListener(this);
        binding.button21.setOnClickListener(this);
        binding.button22.setOnClickListener(this);
        binding.button23.setOnClickListener(this);
        binding.button24.setOnClickListener(this);
        binding.button25.setOnClickListener(this);
        binding.button26.setOnClickListener(this);
        binding.button25.setOnClickListener(this);
        binding.button28.setOnClickListener(this);
        binding.button29.setOnClickListener(this);


    }

    private void startLoadingRewardedAd(String rewardedId) {
        loadingDialog.show();
        loadRewardedAd(rewardedId);
    }


    private void startRequiredActivity() {
        if (flag == 1) {
            Intent pipefittertrainingpart1 = new Intent(this, pipefittertrainingpart1.class);
            startActivity(pipefittertrainingpart1);
        } else if (flag == 2) {
            Intent pipefittertrainingpart2 = new Intent(this, pipefittertrainingpart2.class);
            startActivity(pipefittertrainingpart2);
        } else if (flag == 3) {
            Intent pipefittertrainingpart3 = new Intent(this, pipefittertrainingpart3.class);
            startActivity(pipefittertrainingpart3);
        } else if (flag == 4) {
            Intent pipefittertrainingpart4 = new Intent(this, pipefittertrainingpart4.class);
            startActivity(pipefittertrainingpart4);
        } else if (flag == 5) {
            Intent pipefittertrainingpart5 = new Intent(this, pipefittertrainingpart5.class);
            startActivity(pipefittertrainingpart5);


        } else if (flag == 6) {
            Intent pipefittertrainingpart6 = new Intent(this, pipefittertrainingpart6.class);
            startActivity(pipefittertrainingpart6);
        } else if (flag == 7) {
            Intent pipefittertrainingpart7 = new Intent(this, pipefittertrainingpart7.class);
            startActivity(pipefittertrainingpart7);
        } else if (flag == 8) {
            Intent pipefittertrainingpart8 = new Intent(this, pipefittertrainingpart8.class);
            startActivity(pipefittertrainingpart8);
        } else if (flag == 9) {
            Intent pipefittertrainingpart9 = new Intent(this, pipefittertrainingpart9.class);
            startActivity(pipefittertrainingpart9);
        } else if (flag == 10) {
            Intent pipefittertrainingpart10 = new Intent(this, pipefittertrainingpart10.class);
            startActivity(pipefittertrainingpart10);
        } else if (flag == 11) {
            Intent pipefittertrainingpart11 = new Intent(this, pipefittertrainingpart11.class);
            startActivity(pipefittertrainingpart11);



        } else if (flag == 12) {
            Intent pipefittertrainingpart12 = new Intent(this, pipefittertrainingpart12.class);
            startActivity(pipefittertrainingpart12);
        } else if (flag == 13) {
            Intent pipefittertrainingpart13 = new Intent(this, pipefittertrainingpart13.class);
            startActivity(pipefittertrainingpart13);
        } else if (flag == 14) {
            Intent pipefittertrainingpart14 = new Intent(this, pipefittertrainingpart14.class);
            startActivity(pipefittertrainingpart14);
        } else if (flag == 15) {
            Intent pipefittertrainingpart15 = new Intent(this, pipefittertrainingpart15.class);
            startActivity(pipefittertrainingpart15);


        } else if (flag == 16) {
            Intent pipefittertrainingpart16 = new Intent(this, pipefittertrainingpart16.class);
            startActivity(pipefittertrainingpart16);
        } else if (flag == 17) {
            Intent pipefittertrainingpart17 = new Intent(this, pipefittertrainingpart17.class);
            startActivity(pipefittertrainingpart17);
        } else if (flag == 18) {
            Intent pipefittertrainingpart18 = new Intent(this, pipefittertrainingpart18.class);
            startActivity(pipefittertrainingpart18);
        } else if (flag == 19) {
            Intent pipefittertrainingpart19 = new Intent(this, pipefittertrainingpart19.class);
            startActivity(pipefittertrainingpart19);
        } else if (flag == 20) {
            Intent pipefittertrainingpart20 = new Intent(this, pipefittertrainingpart20.class);
            startActivity(pipefittertrainingpart20);



        } else if (flag == 21) {
            Intent pipefittertrainingpart21 = new Intent(this, pipefittertrainingpart21.class);
            startActivity(pipefittertrainingpart21);



        } else if (flag == 22) {
            Intent pipefittertrainingpart22 = new Intent(this, pipefittertrainingpart22.class);
            startActivity(pipefittertrainingpart22);
        } else if (flag == 23) {
            Intent pipefittertrainingpart23 = new Intent(this, pipefittertrainingpart23.class);
            startActivity(pipefittertrainingpart23);
        } else if (flag == 24) {
            Intent pipefittertrainingpart24 = new Intent(this, pipefittertrainingpart24.class);
            startActivity(pipefittertrainingpart24);
        } else if (flag == 25) {
            Intent pipefittertrainingpart25 = new Intent(this, pipefittertrainingpart25.class);
            startActivity(pipefittertrainingpart25);


        } else if (flag == 26) {
            Intent pipefittertrainingpart26 = new Intent(this, pipefittertrainingpart26.class);
            startActivity(pipefittertrainingpart26);
        } else if (flag == 27) {
            Intent pipefittertrainingpart27 = new Intent(this, pipefittertrainingpart27.class);
            startActivity(pipefittertrainingpart27);
        } else if (flag == 28) {
            Intent pipefittertrainingpart28 = new Intent(this, pipefittertrainingpart28.class);
            startActivity(pipefittertrainingpart28);
        } else if (flag == 29) {
            Intent pipefittertrainingpart29 = new Intent(this, pipefittertrainingpart29.class);
            startActivity(pipefittertrainingpart29);






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
                //        Toast.makeText(pipefitterbasictoadvancemenu.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                            Activity activityContext = pipefitterbasictoadvancemenu.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Toast.makeText(pipefitterbasictoadvancemenu.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                   //         Toast.makeText(pipefitterbasictoadvancemenu.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart1));
                break;
            case R.id.button2:
                flag = 2;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart2));
                break;
            case R.id.button3:
                flag = 3;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart3));
                break;
            case R.id.button4:
                flag = 4;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart4));
                break;
            case R.id.button5:
                flag = 5;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart5));
                break;
            case R.id.button6:
                flag = 6;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart6));
                break;
            case R.id.button7:
                flag = 7;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart7));
                break;
            case R.id.button8:
                flag = 8;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart8));
                break;
            case R.id.button9:
                flag = 9;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart9));
                break;
            case R.id.button10:
                flag = 10;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart10));
                break;

            case R.id.button11:
                flag = 11;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart11));
                break;
            case R.id.button12:
                flag = 12;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart12));
                break;
            case R.id.button13:
                flag = 13;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart13));
                break;
            case R.id.button14:
                flag = 14;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart14));
                break;
            case R.id.button15:
                flag = 15;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart15));
                break;
            case R.id.button16:
                flag = 16;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart16));
                break;
            case R.id.button17:
                flag = 17;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart17));
                break;
            case R.id.button18:
                flag = 18;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart18));
                break;
            case R.id.button19:
                flag = 19;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart19));
                break;
            case R.id.button20:
                flag = 20;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart20));
                break;



            case R.id.button21:
                flag = 21;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart21));
                break;
            case R.id.button22:
                flag = 22;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart22));
                break;
            case R.id.button23:
                flag = 23;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart23));
                break;
            case R.id.button24:
                flag = 24;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart24));
                break;
            case R.id.button25:
                flag = 25;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart25));
                break;
            case R.id.button26:
                flag = 26;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart26));
                break;
            case R.id.button27:
                flag = 27;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart27));
                break;
            case R.id.button28:
                flag = 28;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart28));
                break;
            case R.id.button29:
                flag = 29;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipefittertrainingpart29));
                break;





            default:
                break;
        }
    }
}



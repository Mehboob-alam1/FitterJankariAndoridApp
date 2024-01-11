package com.fitterkipurijankarisalman.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;


import android.app.Activity;
import android.app.Dialog;
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
import com.fitterkipurijankarisalman.myapplication.SubscriptionActivity;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityHowtomaketeebranchBinding;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;


public class howtomaketeebranch extends AppCompatActivity implements View.OnClickListener {

    private ActivityHowtomaketeebranchBinding binding;
    private Dialog loadingDialog;

    private RewardedAd mRewardedAd;

    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityHowtomaketeebranchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);

        binding.button1.setOnClickListener(this);
        binding.button2.setOnClickListener(this);
        binding.button3.setOnClickListener(this);
        binding.button4.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.menu_search);
        final androidx.appcompat.widget.SearchView searchView = (androidx.appcompat.widget.SearchView) MenuItemCompat.getActionView(searchViewItem);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchView.clearFocus();
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                newText = newText.toLowerCase();
                hideAllButtons();
                if (newText.isEmpty()) {
                    //            showAllButtons();
                }
                if (binding.button1.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 1");
                    showSpecificButton(1);
                }
                else {
                    Log.w("searchFun", "Hide all buttons");
                    hideAllButtons();
                }
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    //
//
    private void showSpecificButton(int i) {
        if (i == 1) {
            binding.button1.setVisibility(View.VISIBLE);
        }
    }

    private void hideSpecificButton(int i) {
        if (i == 1) {
            binding.button1.setVisibility(View.GONE);
        }
    }

    private void hideAllButtons() {
        binding.button1.setVisibility(View.GONE);

    }

    private void showAllButtons() {
        binding.button1.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_search) {
            return true;
        } else if (item.getItemId() == R.id.menu_no_ads) {
            startActivity(new Intent(
                    getBaseContext(), SubscriptionActivity.class
            ));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
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
            Intent equalteebranchpdf = new Intent(this, equalteebranchpdf.class);
            startActivity(equalteebranchpdf);
        } else if (flag == 2) {
            Intent unequalteebranchpdf = new Intent(this, unequalteebranchpdf.class);
            startActivity(unequalteebranchpdf);
        } else if (flag == 3) {
            Intent equallateralteebranchpdf = new Intent(this, equallateralteebranchpdf.class);
            startActivity(equallateralteebranchpdf);
        } else if (flag == 4) {
            Intent unequallateralteebranchpdf = new Intent(this, unequallateralteebranchpdf.class);
            startActivity(unequallateralteebranchpdf);

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
                        Toast.makeText(howtomaketeebranch.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                            Activity activityContext = howtomaketeebranch.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Toast.makeText(howtomaketeebranch.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            Toast.makeText(howtomaketeebranch.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_equalteebranchpdf));
                break;
            case R.id.button2:
                flag = 2;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_unequalteebranchpdf));
                break;
            case R.id.button3:
                flag = 3;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_equallateralteebranchpdf));
                break;
            case R.id.button4:
                flag = 4;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_unequallateralteebranchpdf));
                break;
            default:
                break;
        }
    }
}



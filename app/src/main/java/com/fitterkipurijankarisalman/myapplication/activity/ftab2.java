package com.fitterkipurijankarisalman.myapplication.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import com.fitterkipurijankarisalman.myapplication.Config;
import com.fitterkipurijankarisalman.myapplication.SubscriptionActivity;
import com.fitterkipurijankarisalman.myapplication.databinding.FragmentFtab2Binding;
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
import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;

public class ftab2 extends Fragment implements View.OnClickListener {

    private FragmentFtab2Binding binding;
    private Dialog loadingDialog;
    boolean doubleBackToExitPressedOnce = false;

    private InterstitialAd mInterstitialAd;
    private RewardedAd mRewardedAd;

    private int flag = 0;

    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFtab2Binding.inflate(
                inflater,
                container,
                false
        );
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(mContext);

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

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.main_menu, menu);

        MenuItem searchViewItem = menu.findItem(R.id.menu_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
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
                    showAllButtons();
                }
                if (binding.button1.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 1");
                    showSpecificButton(1);
                }
                if (binding.button2.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 2");
                    showSpecificButton(2);
                }
                if (binding.button3.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 3");
                    showSpecificButton(3);
                }
                if (binding.button4.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 4");
                    showSpecificButton(4);
                }
                if (binding.button5.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 5");
                    showSpecificButton(5);
                }
                if (binding.button6.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 6");
                    showSpecificButton(6);

                }
                if (binding.button7.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 7");
                    showSpecificButton(7);
                }
                if (binding.button8.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 8");
                    showSpecificButton(8);
                }
                if (binding.button9.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 9");
                    showSpecificButton(9);
                }
                if (binding.button10.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 10");
                    showSpecificButton(10);
                }
                if (binding.button11.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 11");
                    showSpecificButton(11);

                }
                if (binding.button12.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 12");
                    showSpecificButton(12);
                }
                if (binding.button13.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 13");
                    showSpecificButton(13);
                }
                if (binding.button14.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 14");
                    showSpecificButton(14);
                }
                if (binding.button15.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 15");
                    showSpecificButton(15);



                } else {
                    Log.w("searchFun", "Hide all buttons");
                    //hideAllButtons();
                }

                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void showSpecificButton(int i) {
        if (i == 1) {
            binding.button1.setVisibility(View.VISIBLE);
        } else if (i == 2) {
            binding.button2.setVisibility(View.VISIBLE);
        } else if (i == 3) {
            binding.button3.setVisibility(View.VISIBLE);
        } else if (i == 4) {
            binding.button4.setVisibility(View.VISIBLE);
        } else if (i == 5) {
            binding.button5.setVisibility(View.VISIBLE);
        } else if (i == 6) {
            binding.button6.setVisibility(View.VISIBLE);

        } else if (i == 7) {
            binding.button7.setVisibility(View.VISIBLE);
        } else if (i == 8) {
            binding.button8.setVisibility(View.VISIBLE);
        } else if (i == 9) {
            binding.button9.setVisibility(View.VISIBLE);
        } else if (i == 10) {
            binding.button10.setVisibility(View.VISIBLE);
        } else if (i == 11) {
            binding.button11.setVisibility(View.VISIBLE);
        } else if (i == 12) {
            binding.button12.setVisibility(View.VISIBLE);
        } else if (i == 13) {
            binding.button13.setVisibility(View.VISIBLE);
        } else if (i == 14) {
            binding.button14.setVisibility(View.VISIBLE);
        } else if (i == 15) {
            binding.button15.setVisibility(View.VISIBLE);


        }
    }

    private void hideSpecificButton(int i) {
        if (i == 1) {
            binding.button1.setVisibility(View.GONE);
        } else if (i == 2) {
            binding.button2.setVisibility(View.GONE);
        } else if (i == 3) {
            binding.button3.setVisibility(View.GONE);
        } else if (i == 4) {
            binding.button4.setVisibility(View.GONE);
        } else if (i == 5) {
            binding.button5.setVisibility(View.GONE);
        } else if (i == 6) {
            binding.button6.setVisibility(View.GONE);

        } else if (i == 7) {
            binding.button7.setVisibility(View.GONE);
        } else if (i == 8) {
            binding.button8.setVisibility(View.GONE);
        } else if (i == 9) {
            binding.button9.setVisibility(View.GONE);
        } else if (i == 10) {
            binding.button10.setVisibility(View.GONE);
        } else if (i == 11) {
            binding.button11.setVisibility(View.GONE);

        } else if (i == 12) {
            binding.button12.setVisibility(View.GONE);
        } else if (i == 13) {
            binding.button13.setVisibility(View.GONE);
        } else if (i == 14) {
            binding.button14.setVisibility(View.GONE);
        } else if (i == 15) {
            binding.button15.setVisibility(View.GONE);


        }
    }

    private void hideAllButtons() {
        binding.button1.setVisibility(View.GONE);
        binding.button2.setVisibility(View.GONE);
        binding.button3.setVisibility(View.GONE);
        binding.button4.setVisibility(View.GONE);
        binding.button5.setVisibility(View.GONE);
        binding.button6.setVisibility(View.GONE);

        binding.button7.setVisibility(View.GONE);
        binding.button8.setVisibility(View.GONE);
        binding.button9.setVisibility(View.GONE);
        binding.button10.setVisibility(View.GONE);
        binding.button11.setVisibility(View.GONE);
        binding.button12.setVisibility(View.GONE);
        binding.button13.setVisibility(View.GONE);
        binding.button14.setVisibility(View.GONE);
        binding.button15.setVisibility(View.GONE);


    }

    private void showAllButtons() {
        binding.button1.setVisibility(View.VISIBLE);
        binding.button2.setVisibility(View.VISIBLE);
        binding.button3.setVisibility(View.VISIBLE);
        binding.button4.setVisibility(View.VISIBLE);
        binding.button5.setVisibility(View.VISIBLE);
        binding.button6.setVisibility(View.VISIBLE);

        binding.button7.setVisibility(View.VISIBLE);
        binding.button8.setVisibility(View.VISIBLE);
        binding.button9.setVisibility(View.VISIBLE);
        binding.button10.setVisibility(View.VISIBLE);
        binding.button11.setVisibility(View.VISIBLE);
        binding.button12.setVisibility(View.VISIBLE);
        binding.button13.setVisibility(View.VISIBLE);
        binding.button14.setVisibility(View.VISIBLE);
        binding.button15.setVisibility(View.VISIBLE);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_search) {
            return true;
        } else if (item.getItemId() == R.id.menu_no_ads) {
            startActivity(new Intent(
                    getContext(), SubscriptionActivity.class
            ));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void startLoadingInterstitialAd(String interstitialId) {
        if (!Config.isPaidUser) {
            loadingDialog.show();
            loadInterstitialAd(interstitialId);
        } else {
            startRequiredActivity();
        }
    }

    private void startLoadingRewardedAd(String rewardedId) {
        if (!Config.isPaidUser) {
            loadingDialog.show();
            loadRewardedAd(rewardedId);
        } else {
            startRequiredActivity();
        }
    }

    private void startRequiredActivity() {
        if (flag == 1) {
            Intent pipeodchart = new Intent(mContext, pipeodchart.class);
            startActivity(pipeodchart);
        } else if (flag == 2) {
            Intent sspipewightchart = new Intent(mContext, sspipewightchart.class);
            startActivity(sspipewightchart);
        } else if (flag == 3) {
            Intent pipeshedulechart = new Intent(mContext, pipeschedulechart.class);
            startActivity(pipeshedulechart);
        } else if (flag == 4) {
            Intent flangeodidpcdchart = new Intent(mContext, flangeodidpcdchart.class);
            startActivity(flangeodidpcdchart);
        } else if (flag == 5) {
            Intent spannersizechart = new Intent(mContext, spannersizechart.class);
            startActivity(spannersizechart);
        } else if (flag == 6) {
            Intent plateweightkgpersqmeter = new Intent(mContext, plateweightkgpersqmeter.class);
            startActivity(plateweightkgpersqmeter);
        } else if (flag == 7) {
            Intent drawingshortcut = new Intent(mContext, drawingshortcutt.class);
            startActivity(drawingshortcut);
        } else if (flag == 8) {
            Intent drawingsymbol = new Intent(mContext, drawingsymbol.class);
            startActivity(drawingsymbol);
        } else if (flag == 9) {
            Intent beamunitweight = new Intent(mContext, beamunitweight.class);
            startActivity(beamunitweight);
        } else if (flag == 10) {
            Intent angleweightkgpermeter = new Intent(mContext, angleweightkgpermeter.class);
            startActivity(angleweightkgpermeter);
        } else if (flag == 11) {
            Intent channelunitweight = new Intent(mContext, channelunitweight.class);
            startActivity(channelunitweight);
        } else if (flag == 12) {
            Intent chqdplateunitweight = new Intent(mContext, chqdplateunitweight.class);
            startActivity(chqdplateunitweight);
        } else if (flag == 13) {
            Intent railunitweight = new Intent(mContext, railunitweight.class);
            startActivity(railunitweight);
        } else if (flag == 14) {
            Intent ubunitweight = new Intent(mContext, ubunitweight.class);
            startActivity(ubunitweight);
        } else if (flag == 15) {
            Intent wpbunitweight = new Intent(mContext, wpbunitweight.class);
            startActivity(wpbunitweight);



        }
    }

    private void loadInterstitialAd(String id) {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(mContext, id, adRequest,
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
                                Toast.makeText(mContext, "Ad failed to load full screen content", Toast.LENGTH_SHORT).show();
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
                            mInterstitialAd.show(getActivity());
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                        loadingDialog.dismiss();
                        startRequiredActivity();
                 //       Toast.makeText(mContext, "Ad failed to load.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadRewardedAd(String rewardedId) {
        AdRequest adRequest = new AdRequest.Builder().build();

        RewardedAd.load(mContext, rewardedId,
                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mRewardedAd = null;
                        loadingDialog.dismiss();
                        startRequiredActivity();
                 //       Toast.makeText(mContext, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                            Activity activityContext = getActivity();
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                }
                            });
                        } else {
                            Toast.makeText(mContext, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipeodchart));
                break;

            case R.id.button2:
                flag = 2;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipesizewithcf));
                break;

            case R.id.button3:
                flag = 3;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipeschedulechart));
                break;

            case R.id.button4:
                flag = 4;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_flangeidodpcdchart));
                break;

            case R.id.button5:
                flag = 5;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_spannersizechart));
                break;

            case R.id.button6:
                flag = 6;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_plateweightkgpermeter));
                break;

            case R.id.button7:
                flag = 7;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_drawingshortcut));
                break;

            case R.id.button8:
                flag = 8;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_structuredrawingsymbol));
                break;

            case R.id.button9:
                flag = 9;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_beamunitweight));
                break;

            case R.id.button10:
                flag = 10;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_angleweightkgpermeter));
                break;

            case R.id.button11:
                flag = 11;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_channelunitweight));
                break;
            case R.id.button12:
                flag = 12;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_chqdplateunitweight));
                break;
            case R.id.button13:
                flag = 13;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_railunitweight));
                break;
            case R.id.button14:
                flag = 14;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_ubunitweight));
                break;
            case R.id.button15:
                flag = 15;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_wpbunitweight));
                break;

            default:
                break;
        }
    }
}
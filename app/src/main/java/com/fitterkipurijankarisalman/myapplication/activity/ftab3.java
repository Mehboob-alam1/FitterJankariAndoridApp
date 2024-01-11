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

import com.fitterkipurijankarisalman.myapplication.SubscriptionActivity;
import com.fitterkipurijankarisalman.myapplication.databinding.FragmentFtab3Binding;
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

public class ftab3 extends Fragment implements View.OnClickListener {

    private FragmentFtab3Binding binding;
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
        binding = FragmentFtab3Binding.inflate(
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
        binding.button03.setOnClickListener(this);
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
                if (binding.button03.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 03");
                    showSpecificButton(03);
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
                }
                if (binding.button16.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 16");
                    showSpecificButton(16);

                }
                if (binding.button17.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 17");
                    showSpecificButton(17);
                }
                if (binding.button18.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 18");
                    showSpecificButton(18);
                }
                if (binding.button19.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 19");
                    showSpecificButton(19);
                }
                if (binding.button20.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 20");
                    showSpecificButton(20);
                }
                if (binding.button21.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 21");
                    showSpecificButton(21);
                }
                if (binding.button22.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 22");
                    showSpecificButton(22);



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
        } else if (i == 03) {
            binding.button03.setVisibility(View.VISIBLE);
        }else if (i == 4) {
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
        } else if (i == 16) {
            binding.button16.setVisibility(View.VISIBLE);

        } else if (i == 17) {
            binding.button17.setVisibility(View.VISIBLE);
        } else if (i == 18) {
            binding.button18.setVisibility(View.VISIBLE);
        } else if (i == 19) {
            binding.button19.setVisibility(View.VISIBLE);
        } else if (i == 20) {
            binding.button20.setVisibility(View.VISIBLE);
        } else if (i == 21) {
            binding.button21.setVisibility(View.VISIBLE);
        } else if (i == 22) {
            binding.button22.setVisibility(View.VISIBLE);



        }
    }

    private void hideSpecificButton(int i) {
        if (i == 1) {
            binding.button1.setVisibility(View.GONE);
        } else if (i == 2) {
            binding.button2.setVisibility(View.GONE);
        } else if (i == 3) {
            binding.button3.setVisibility(View.GONE);
        } else if (i == 03) {
            binding.button03.setVisibility(View.GONE);
        }else if (i == 4) {
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
        } else if (i == 16) {
            binding.button16.setVisibility(View.GONE);

        } else if (i == 17) {
            binding.button17.setVisibility(View.GONE);
        } else if (i == 18) {
            binding.button18.setVisibility(View.GONE);
        } else if (i == 19) {
            binding.button19.setVisibility(View.GONE);
        } else if (i == 20) {
            binding.button20.setVisibility(View.GONE);
        } else if (i == 21) {
            binding.button21.setVisibility(View.GONE);
        } else if (i == 22) {
            binding.button22.setVisibility(View.GONE);

        }
    }

    private void hideAllButtons() {
        binding.button1.setVisibility(View.GONE);
        binding.button2.setVisibility(View.GONE);
        binding.button3.setVisibility(View.GONE);
        binding.button03.setVisibility(View.GONE);
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
        binding.button16.setVisibility(View.GONE);

        binding.button17.setVisibility(View.GONE);
        binding.button18.setVisibility(View.GONE);
        binding.button19.setVisibility(View.GONE);
        binding.button20.setVisibility(View.GONE);
        binding.button21.setVisibility(View.GONE);
        binding.button22.setVisibility(View.GONE);


    }

    private void showAllButtons() {
        binding.button1.setVisibility(View.VISIBLE);
        binding.button2.setVisibility(View.VISIBLE);
        binding.button3.setVisibility(View.VISIBLE);
        binding.button03.setVisibility(View.VISIBLE);
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
        binding.button16.setVisibility(View.VISIBLE);

        binding.button17.setVisibility(View.VISIBLE);
        binding.button18.setVisibility(View.VISIBLE);
        binding.button19.setVisibility(View.VISIBLE);
        binding.button20.setVisibility(View.VISIBLE);
        binding.button21.setVisibility(View.VISIBLE);
        binding.button22.setVisibility(View.VISIBLE);



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
        loadingDialog.show();
        loadInterstitialAd(interstitialId);
    }

    private void startLoadingRewardedAd(String rewardedId) {
        loadingDialog.show();
        loadRewardedAd(rewardedId);
    }

    private void startRequiredActivity() {
        if (flag == 1) {
            Intent elbowformula = new Intent(mContext, elbowformula.class);
            startActivity(elbowformula);
        } else if (flag == 2) {
            Intent howtocalculatechordlength = new Intent(mContext, howtocalculatechordlength.class);
            startActivity(howtocalculatechordlength);
        } else if (flag == 3) {
            Intent conekaradiuskeliyedegreekaisenikale = new Intent(mContext, conekaradiuskeliyedegreekaisenikale.class);
            startActivity(conekaradiuskeliyedegreekaisenikale);
        } else if (flag == 03) {
            Intent conekaradiuskaisenikale = new Intent(mContext, conekaradiuskaisenikale.class);
            startActivity(conekaradiuskaisenikale);
        }
        else if (flag == 4) {
            Intent conekadegreekaisenikale = new Intent(mContext, conekadegreekaisenikale.class);
            startActivity(conekadegreekaisenikale);
        } else if (flag == 5) {
            Intent conekamiddlediameterkaisenikale = new Intent(mContext, conekamiddlediameterkaisenikale.class);
            startActivity(conekamiddlediameterkaisenikale);
        } else if (flag == 6) {
            Intent bigdiametermiterformula = new Intent(mContext, bigdiametermiterformula.class);
            startActivity(bigdiametermiterformula);
        } else if (flag == 7) {
            Intent howtomaketeebranch = new Intent(mContext, howtomaketeebranch.class);
            startActivity(howtomaketeebranch);
        } else if (flag == 8) {
            Intent ybranchformula = new Intent(mContext, ybranchformula.class);
            startActivity(ybranchformula);
        } else if (flag == 9) {
            Intent headerholeformula = new Intent(mContext, headerholeformula.class);
            startActivity(headerholeformula);
        } else if (flag == 10) {
            Intent flangeformula = new Intent(mContext, flangeformula.class);
            startActivity(flangeformula);
        } else if (flag == 11) {
            Intent reducerpdfmenu = new Intent(mContext, reducerpdfmenu.class);
            startActivity(reducerpdfmenu);
        } else if (flag == 12) {
            Intent elbowcenterradius = new Intent(mContext, elbowcenterradius.class);
            startActivity(elbowcenterradius);
        } else if (flag == 13) {
            Intent pipeweightkgpermeter = new Intent(mContext, pipeweightkgpermeter.class);
            startActivity(pipeweightkgpermeter);
        } else if (flag == 14) {
            Intent metalweightformula = new Intent(mContext, metalweightformula.class);
            startActivity(metalweightformula);



        } else if (flag == 15) {
            Intent elbowcenterradius = new Intent(mContext, elbowcenterradius.class);
            startActivity(elbowcenterradius);
        } else if (flag == 16) {
            Intent weldingweightformula = new Intent(mContext, weldingweightformula.class);
            startActivity(weldingweightformula);
        } else if (flag == 17) {
            Intent degreetommconversion = new Intent(mContext, degreetommconversion.class);
            startActivity(degreetommconversion);
        } else if (flag == 18) {
            Intent anydegreeelbowcutting = new Intent(mContext, anydegreeelbowcutting.class);
            startActivity(anydegreeelbowcutting);
        } else if (flag == 19) {
            Intent howtofinddegree = new Intent(mContext, howtofinddegree.class);
            startActivity(howtofinddegree);
        } else if (flag == 20) {
            Intent pipebevelformula = new Intent(mContext, pipebevelformula.class);
            startActivity(pipebevelformula);
        } else if (flag == 21) {
            Intent coneformula = new Intent(mContext, coneformula.class);
            startActivity(coneformula);
        } else if (flag == 22) {
            Intent coneweightformula = new Intent(mContext, coneweightformula.class);
            startActivity(coneweightformula);




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
                //        Toast.makeText(mContext, "Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_elbowformula));
                break;

            case R.id.button2:
                flag = 2;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_howtocalculculatechordlength));
                break;

            case R.id.button3:
                flag = 3;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_conekaradiuskeliyedegreekaisenikale));
                break;

            case R.id.button03:
                flag = 03;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_conekaradiuskaisenikale));
                break;

            case R.id.button4:
                flag = 4;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_conekadegreekaisenikale));
                break;

            case R.id.button5:
                flag = 5;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_conekamiddlediakaisenikale));
                break;

            case R.id.button6:
                flag = 6;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_miterformula));
                break;

            case R.id.button7:
                flag = 7;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_teebranchformula));
                break;

            case R.id.button8:
                flag = 8;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_ybranch));
                break;

            case R.id.button9:
                flag = 9;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_headerholeformula));
                break;

            case R.id.button10:
                flag = 10;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_flangeholeformula));
                break;

            case R.id.button11:
                flag = 11;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_reducerformula));
                break;
            case R.id.button12:
                flag = 12;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_elbowcenterradius));
                break;
            case R.id.button13:
                flag = 13;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipeweightkgperm));
                break;
            case R.id.button14:
                flag = 14;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_metalweightformula));
                break;

            case R.id.button15:
                flag = 15;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_elbowcenterradiuss));
                break;

            case R.id.button16:
                flag = 16;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_weldingweightformula));
                break;

            case R.id.button17:
                flag = 17;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_degreetommconversion));
                break;

            case R.id.button18:
                flag = 18;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_anydegreeelbowcuttingformula));
                break;

            case R.id.button19:
                flag = 19;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_degreeformula));
                break;

            case R.id.button20:
                flag = 20;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_bevelformula));
                break;

            case R.id.button21:
                flag = 21;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_coneformula));
                break;
            case R.id.button22:
                flag = 22;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_coneweightformula));
                break;





            default:
                break;
        }
    }
}
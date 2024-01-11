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
import com.fitterkipurijankarisalman.myapplication.databinding.ActivityDrawingshortcuttBinding;

import com.fitterkipurijankarisalman.myapplication.databinding.ActivityPipeodchartBinding;
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

public class pipeodchart extends AppCompatActivity implements View.OnClickListener {

    private ActivityPipeodchartBinding binding;
//    private Dialog loadingDialog;

    private RewardedAd mRewardedAd;
    private InterstitialAd mInterstitialAd;

    private int flag = 0;

    private Context mContext;

    //@Override
    public void onAttach(Context context) {
  //      super.onAttach(context);
        mContext = context;
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityPipeodchartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);


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
        binding.button27.setOnClickListener(this);
        binding.button28.setOnClickListener(this);
        binding.button29.setOnClickListener(this);
        binding.button30.setOnClickListener(this);
        binding.button31.setOnClickListener(this);

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
                }
                if (binding.button23.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 23");
                    showSpecificButton(23);
                }
                if (binding.button24.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 24");
                    showSpecificButton(24);
                }
                if (binding.button25.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 25");
                    showSpecificButton(25);
                }
                if (binding.button26.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 26");
                    showSpecificButton(26);
                }
                if (binding.button27.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 27");
                    showSpecificButton(27);
                }
                if (binding.button28.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 28");
                    showSpecificButton(28);
                }
                if (binding.button29.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 29");
                    showSpecificButton(29);
                }
                if (binding.button30.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 30");
                    showSpecificButton(30);
                }
                if (binding.button31.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 31");
                    showSpecificButton(31);

                } else {
                    Log.w("searchFun", "Hide all buttons");
                    //hideAllButtons();
                }

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);

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
        } else if (i == 23) {
            binding.button23.setVisibility(View.VISIBLE);
        } else if (i == 24) {
            binding.button24.setVisibility(View.VISIBLE);
        } else if (i == 25) {
            binding.button25.setVisibility(View.VISIBLE);
        } else if (i == 26) {
            binding.button26.setVisibility(View.VISIBLE);
        } else if (i == 27) {
            binding.button27.setVisibility(View.VISIBLE);
        } else if (i == 28) {
            binding.button28.setVisibility(View.VISIBLE);
        } else if (i == 29) {
            binding.button29.setVisibility(View.VISIBLE);
        } else if (i == 30) {
            binding.button30.setVisibility(View.VISIBLE);
        } else if (i == 31) {
            binding.button31.setVisibility(View.VISIBLE);

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
        } else if (i == 23) {
            binding.button23.setVisibility(View.GONE);
        } else if (i == 24) {
            binding.button24.setVisibility(View.GONE);
        } else if (i == 25) {
            binding.button25.setVisibility(View.GONE);
        } else if (i == 26) {
            binding.button26.setVisibility(View.GONE);
        } else if (i == 27) {
            binding.button27.setVisibility(View.GONE);
        } else if (i == 28) {
            binding.button28.setVisibility(View.GONE);
        } else if (i == 29) {
            binding.button29.setVisibility(View.GONE);
        } else if (i == 30) {
            binding.button30.setVisibility(View.GONE);
        } else if (i == 31) {
            binding.button31.setVisibility(View.GONE);

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
        binding.button16.setVisibility(View.GONE);
        binding.button17.setVisibility(View.GONE);
        binding.button18.setVisibility(View.GONE);
        binding.button19.setVisibility(View.GONE);
        binding.button20.setVisibility(View.GONE);
        binding.button21.setVisibility(View.GONE);
        binding.button22.setVisibility(View.GONE);
        binding.button23.setVisibility(View.GONE);
        binding.button24.setVisibility(View.GONE);
        binding.button25.setVisibility(View.GONE);
        binding.button26.setVisibility(View.GONE);
        binding.button27.setVisibility(View.GONE);
        binding.button28.setVisibility(View.GONE);
        binding.button29.setVisibility(View.GONE);
        binding.button30.setVisibility(View.GONE);
        binding.button31.setVisibility(View.GONE);

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
        binding.button16.setVisibility(View.VISIBLE);
        binding.button17.setVisibility(View.VISIBLE);
        binding.button18.setVisibility(View.VISIBLE);
        binding.button19.setVisibility(View.VISIBLE);
        binding.button20.setVisibility(View.VISIBLE);
        binding.button21.setVisibility(View.VISIBLE);
        binding.button22.setVisibility(View.VISIBLE);
        binding.button23.setVisibility(View.VISIBLE);
        binding.button24.setVisibility(View.VISIBLE);
        binding.button25.setVisibility(View.VISIBLE);
        binding.button26.setVisibility(View.VISIBLE);
        binding.button27.setVisibility(View.VISIBLE);
        binding.button28.setVisibility(View.VISIBLE);
        binding.button29.setVisibility(View.VISIBLE);
        binding.button30.setVisibility(View.VISIBLE);
        binding.button31.setVisibility(View.VISIBLE);

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

    private void startLoadingInterstitialAd(String interstitialId) {
        if (!Config.isPaidUser) {
    //        loadingDialog.show();
            loadInterstitialAd(interstitialId);
        } else {
       //     startRequiredActivity();
        }
    }

    private void startLoadingRewardedAd(String rewardedId) {
        if (!Config.isPaidUser) {
      //      loadingDialog.show();
            loadRewardedAd(rewardedId);
        } else {
     //       startRequiredActivity();
        }
    }

    //   private void startRequiredActivity() {
    //       if (flag == 1) {
    //           Intent anydegreeelbowcutting = new Intent(this, anydegreeelbowcutting.class);
    //           startActivity(anydegreeelbowcutting);
    //      }
    //       else if (flag == 2) {
    //           Intent elbowcentercalculation = new Intent(this, elbowcentercalculation.class);
    //           startActivity(elbowcentercalculation);
    //       } else if (flag == 3) {
    //           Intent howtomakeelbow = new Intent(this, howtomakeelbow.class);
    //           startActivity(howtomakeelbow);
    //       } else if (flag == 4) {
    //           Intent colorsofpipeline = new Intent(this, colorsofpipeline.class);
    //           startActivity(colorsofpipeline);
    //      } else if (flag == 5) {
    //           Intent interviewqna = new Intent(this, interviewqna.class);
    //           startActivity(interviewqna);
    //       } else if (flag == 6) {
    //           Intent npsdnnbidod = new Intent(this, npsdnnbidod.class);
    //           startActivity(npsdnnbidod);
    //       } else if (flag == 7) {
    //           Intent headerholeformula = new Intent(this, headerholeformula.class);
    //           startActivity(headerholeformula);
    //       } else if (flag == 8) {
    //           Intent teebranch = new Intent(this, teebranch.class);
    //           startActivity(teebranch);
    //       } else if (flag == 9) {
    //           Intent flangeqna = new Intent(this, flangeqna.class);
    //           startActivity(flangeqna);
    //       } else if (flag == 10) {
    //           Intent elbowcenterformulavideo = new Intent(this, elbowcenterformulavideo.class);
    //           startActivity(elbowcenterformulavideo);
    //       } else if (flag == 11) {
    //           Intent rightangleformula = new Intent(this, rightangleformula.class);
    //           startActivity(rightangleformula);
    //       } else if (flag == 12) {
    //           Intent typesofflange = new Intent(this, typesofflange.class);
    //           startActivity(typesofflange);
    //       } else if (flag == 13) {
    //           Intent flangemakingformula = new Intent(this, flangemakingformula.class);
    //           startActivity(flangemakingformula);
    //      } else if (flag == 14) {
    //           Intent typesofweldolet = new Intent(this, typesofweldolet.class);
    //           startActivity(typesofweldolet);
    //       } else if (flag == 15) {
    //           Intent howtomakereducer = new Intent(this, howtomakereducer.class);
    //           startActivity(howtomakereducer);
    //       } else if (flag == 16) {
    //           Intent singlemitercutbend = new Intent(this, singlemitercutbend.class);
    //           startActivity(singlemitercutbend);
    //       } else if (flag == 17) {
    //           Intent howtomakeybranch = new Intent(this, howtomakeybranch.class);
    //           startActivity(howtomakeybranch);
    //       } else if (flag == 18) {
    //           Intent howtomaketeebranch = new Intent(this, howtomaketeebranch.class);
    //          startActivity(howtomaketeebranch);
    //       } else if (flag == 19) {
    //           Intent pipesupporting = new Intent(this, pipesupporting.class);
    //           startActivity(pipesupporting);
    //       } else if (flag == 20) {
    //           Intent importantmeasurement = new Intent(this, importantmeasurement.class);
    //           startActivity(importantmeasurement);
    //      } else if (flag == 21) {
    //          Intent importantshortcut = new Intent(this, importantshortcut.class);
    //          startActivity(importantshortcut);
    //       } else if (flag == 22) {
    //           Intent platetopipefabrication = new Intent(this, platetopipefabrication.class);
    //           startActivity(platetopipefabrication);
    //       } else if (flag == 23) {
    //           Intent coneformula = new Intent(this, coneformula.class);
    //           startActivity(coneformula);
    //       } else if (flag == 24) {
    //           Intent pipeweightkgpermeter = new Intent(this, pipeweightkgpermeter.class);
    //           startActivity(pipeweightkgpermeter);
    //       } else if (flag == 25) {
    //           Intent drawingsymbol = new Intent(this, drawingsymbol.class);
    //          startActivity(drawingsymbol);
    //       } else if (flag == 26) {
    //           Intent whatiscfidod = new Intent(this, whatiscfidod.class);
    //           startActivity(whatiscfidod);
    //       } else if (flag == 27) {
    //           Intent nutbolts = new Intent(this, nutbolts.class);
    //           startActivity(nutbolts);
    //      } else if (flag == 28) {
    //           Intent welding = new Intent(this, welding.class);
    //           startActivity(welding);
    //       } else if (flag == 29) {
    //           Intent cutting = new Intent(this, cutting.class);
    //           startActivity(cutting);
    //       } else if (flag == 30) {
    //           Intent offset = new Intent(this, offset.class);
    //           startActivity(offset);
    //      } else if (flag == 31) {
    //          Intent howtofinddegree = new Intent(this, howtofinddegree.class);
    //           startActivity(howtofinddegree);


//        }
    //  }
//



    private void loadInterstitialAd(String id) {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, id, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        //                  loadingDialog.dismiss();
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                super.onAdClicked();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                //                      startRequiredActivity();
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
                            mInterstitialAd.show(pipeodchart.this);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                        //                loadingDialog.dismiss();
                        //                startRequiredActivity();
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
                        //              loadingDialog.dismiss();
                        //              startRequiredActivity();
                        //              Toast.makeText(drawingshortcutt.this, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                        //              loadingDialog.dismiss();
                        mRewardedAd = rewardedAd;
                        mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdClicked() {
                                super.onAdClicked();
                            }

                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                //                     startRequiredActivity();
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
                            Activity activityContext = pipeodchart.this;
                            mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                                @Override
                                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                                    Toast.makeText(pipeodchart.this, "The user earned the reward.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            Toast.makeText(pipeodchart.this, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;

            case R.id.button2:
                flag = 2;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;

            case R.id.button3:
                flag = 3;
                startLoadingRewardedAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;

            case R.id.button4:
                flag = 4;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;

            case R.id.button5:
                flag = 5;
                startLoadingRewardedAd(getResources().getString(R.string.admob_interstitial_id_interviewqna));
                break;

            case R.id.button6:
                flag = 6;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;

            case R.id.button7:
                flag = 7;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_headerholeformula));
                break;

            case R.id.button8:
                flag = 8;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;

            case R.id.button9:
                flag = 9;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;

            case R.id.button10:
                flag = 10;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;

            case R.id.button11:
                flag = 11;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button12:
                flag = 12;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button13:
                flag = 13;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button14:
                flag = 14;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button15:
                flag = 15;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button16:
                flag = 16;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;
            case R.id.button17:
                flag = 17;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button18:
                flag = 18;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;
            case R.id.button19:
                flag = 19;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button20:
                flag = 20;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button21:
                flag = 21;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button22:
                flag = 22;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_platetopipefabrication));
                break;
            case R.id.button23:
                flag = 23;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button24:
                flag = 24;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button25:
                flag = 25;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button26:
                flag = 26;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button27:
                flag = 27;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button28:
                flag = 28;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button29:
                flag = 29;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button30:
                flag = 30;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button31:
                flag = 31;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button32:
                flag = 32;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button33:
                flag = 33;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;
            case R.id.button34:
                flag = 34;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button35:
                flag = 35;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;
            case R.id.button36:
                flag = 36;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;
            case R.id.button37:
                flag = 37;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;
            case R.id.button38:
                flag = 38;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_arclength));
                break;
            case R.id.button39:
                flag = 39;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_chordlength));
                break;
            case R.id.button40:
                flag = 40;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_aaiyesitedikhatehaivideo));
                break;
            case R.id.button41:
                flag = 41;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button42:
                flag = 42;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button43:
                flag = 43;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_privacypolicy));
                break;

            default:
                break;
        }
    }
}
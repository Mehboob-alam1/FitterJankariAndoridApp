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
import com.fitterkipurijankarisalman.myapplication.databinding.FragmentFtab4Binding;
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

public class ftab4 extends Fragment implements View.OnClickListener {

    private FragmentFtab4Binding binding;
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
        binding = FragmentFtab4Binding.inflate(
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
        //   binding.button13.setOnClickListener(this);
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
        //binding.button25.setOnClickListener(this);
        binding.button26.setOnClickListener(this);
        binding.button27.setOnClickListener(this);
        binding.button28.setOnClickListener(this);
        binding.button29.setOnClickListener(this);
        binding.button30.setOnClickListener(this);
        binding.button31.setOnClickListener(this);
        binding.button32.setOnClickListener(this);
        binding.button33.setOnClickListener(this);
        binding.button34.setOnClickListener(this);
        binding.button35.setOnClickListener(this);
        binding.button36.setOnClickListener(this);
        binding.button37.setOnClickListener(this);

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
                    //    }
                    //         if (binding.button13.getText().toString().toLowerCase().contains(newText)) {
                    //      Log.w("searchFun", "Show button 13");
                    //      showSpecificButton(13);
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
        //       }
        //        if (binding.button25.getText().toString().toLowerCase().contains(newText)) {
        //            Log.w("searchFun", "Show button 25");
        //            showSpecificButton(25);
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
                }
                if (binding.button32.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 32");
                    showSpecificButton(32);
                }
                if (binding.button33.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 33");
                    showSpecificButton(33);
                }
                if (binding.button34.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 34");
                    showSpecificButton(34);
                }
                if (binding.button35.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 35");
                    showSpecificButton(35);
                }
                if (binding.button36.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 36");
                    showSpecificButton(36);
                }
                if (binding.button37.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 37");
                    showSpecificButton(37);


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
            //     } else if (i == 13) {
            //         binding.button13.setVisibility(View.VISIBLE);
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
    //    } else if (i == 25) {
    //        binding.button25.setVisibility(View.VISIBLE);
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
        } else if (i == 32) {
            binding.button32.setVisibility(View.VISIBLE);
        } else if (i == 33) {
            binding.button33.setVisibility(View.VISIBLE);
        } else if (i == 34) {
            binding.button34.setVisibility(View.VISIBLE);
        } else if (i == 35) {
            binding.button35.setVisibility(View.VISIBLE);
        } else if (i == 36) {
            binding.button36.setVisibility(View.VISIBLE);
        } else if (i == 37) {
            binding.button37.setVisibility(View.VISIBLE);


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
            //      } else if (i == 13) {
            //          binding.button13.setVisibility(View.GONE);
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
    //    } else if (i == 25) {
    //        binding.button25.setVisibility(View.GONE);
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
        } else if (i == 32) {
            binding.button32.setVisibility(View.GONE);
        } else if (i == 33) {
            binding.button33.setVisibility(View.GONE);
        } else if (i == 34) {
            binding.button34.setVisibility(View.GONE);
        } else if (i == 35) {
            binding.button35.setVisibility(View.GONE);
        } else if (i == 36) {
            binding.button36.setVisibility(View.GONE);
        } else if (i == 37) {
            binding.button37.setVisibility(View.GONE);

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
        // binding.button13.setVisibility(View.GONE);
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
    //    binding.button25.setVisibility(View.GONE);
        binding.button26.setVisibility(View.GONE);
        binding.button27.setVisibility(View.GONE);
        binding.button28.setVisibility(View.GONE);
        binding.button29.setVisibility(View.GONE);
        binding.button30.setVisibility(View.GONE);
        binding.button31.setVisibility(View.GONE);
        binding.button32.setVisibility(View.GONE);
        binding.button33.setVisibility(View.GONE);
        binding.button34.setVisibility(View.GONE);
        binding.button35.setVisibility(View.GONE);
        binding.button36.setVisibility(View.GONE);
        binding.button37.setVisibility(View.GONE);


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
        //  binding.button13.setVisibility(View.VISIBLE);
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
     //   binding.button25.setVisibility(View.VISIBLE);
        binding.button26.setVisibility(View.VISIBLE);
        binding.button27.setVisibility(View.VISIBLE);
        binding.button28.setVisibility(View.VISIBLE);
        binding.button29.setVisibility(View.VISIBLE);
        binding.button30.setVisibility(View.VISIBLE);
        binding.button31.setVisibility(View.VISIBLE);
        binding.button32.setVisibility(View.VISIBLE);
        binding.button33.setVisibility(View.VISIBLE);
        binding.button34.setVisibility(View.VISIBLE);
        binding.button35.setVisibility(View.VISIBLE);
        binding.button36.setVisibility(View.VISIBLE);
        binding.button37.setVisibility(View.VISIBLE);



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
            Intent liveworkingvideomenu = new Intent(mContext, liveworkingvideomenu.class);
            startActivity(liveworkingvideomenu);
        } else if (flag == 2) {
            Intent diagonalkyahotahai = new Intent(mContext, diagonalkyahotahai.class);
            startActivity(diagonalkyahotahai);
        } else if (flag == 3) {
            Intent veryimportantforcolumnfabrication = new Intent(mContext, veryimportantforcolumnfabrication.class);
            startActivity(veryimportantforcolumnfabrication);
        } else if (flag == 4) {
            Intent pipefitterbasictoadvancemenu = new Intent(mContext, pipefitterbasictoadvancemenu.class);
            startActivity(pipefitterbasictoadvancemenu);
        } else if (flag == 5) {
            Intent learnisometricdrawing = new Intent(mContext, learnisometricdrawing.class);
            startActivity(learnisometricdrawing);
        } else if (flag == 6) {
            Intent canteleversupportvideo = new Intent(mContext, canteleversupportvideo.class);
            startActivity(canteleversupportvideo);
        } else if (flag == 7) {
            Intent platerightangletrick = new Intent(mContext, platerightangletrickmenu.class);
            startActivity(platerightangletrick);
        } else if (flag == 8) {
            Intent staircasevideomenu = new Intent(mContext, staircasevideomenu.class);
            startActivity(staircasevideomenu);
        } else if (flag == 9) {
            Intent handrailkaisebanaye = new Intent(mContext, handrailkaisebanayemenu.class);
            startActivity(handrailkaisebanaye);
        } else if (flag == 10) {
            Intent reducervideomenu = new Intent(mContext, reducervideomenu.class);
            startActivity(reducervideomenu);
        } else if (flag == 11) {
            Intent teebranchvideomenu = new Intent(mContext, teebranchvideomenu.class);
            startActivity(teebranchvideomenu);
        } else if (flag == 12) {
            Intent howtomakeflangevideomenu = new Intent(mContext, howtomakeflangevideomenu.class);
            startActivity(howtomakeflangevideomenu);



        } else if (flag == 14) {
            Intent conevideomenu = new Intent(mContext, conevideomenu.class);
            startActivity(conevideomenu);
        } else if (flag == 15) {
            Intent platetoreducervideomenu = new Intent(mContext, platetoreducervideomenu.class);
            startActivity(platetoreducervideomenu);
        } else if (flag == 16) {
            Intent miterbendvideomenu = new Intent(mContext, miterbendvideomenu.class);
            startActivity(miterbendvideomenu);
        } else if (flag == 17) {
            Intent rpadkaisebanaye = new Intent(mContext, rpadkaisebanaye.class);
            startActivity(rpadkaisebanaye);
        } else if (flag == 18) {
            Intent waterlevelkaisecheckkare = new Intent(mContext, waterlevelkaisecheckkare.class);
            startActivity(waterlevelkaisecheckkare);
        } else if (flag == 19) {
            Intent elbowradiusvideo = new Intent(mContext, elbowradiusvideo.class);
            startActivity(elbowradiusvideo);
        } else if (flag == 20) {
            Intent miterbendlayoutvido = new Intent(mContext, miterbendlayoutvido.class);
            startActivity(miterbendlayoutvido);
        } else if (flag == 21) {
            Intent typesofhoppervideomenu = new Intent(mContext, typesofhoppervideomenu.class);
            startActivity(typesofhoppervideomenu);
        } else if (flag == 22) {
            Intent ybranchvideomenu = new Intent(mContext, ybranchvideomenu.class);
            startActivity(ybranchvideomenu);
        } else if (flag == 23) {
            Intent drawingfitterkaisebanevideomenu = new Intent(mContext, drawingfitterkaisebanevideomenu.class);
            startActivity(drawingfitterkaisebanevideomenu);
        } else if (flag == 24) {
            Intent platekatankkaisebnayevideomenu = new Intent(mContext, platekatankkaisebnayevideomenu.class);
            startActivity(platekatankkaisebnayevideomenu);
        //} else if (flag == 25) {
        //    Intent platekatankkaisebnayevideomenu = new Intent(mContext, platekatankkaisebnayevideomenu.class);
        //    startActivity(platekatankkaisebnayevideomenu);
        } else if (flag == 26) {
            Intent anydegreepipeoffset = new Intent(mContext, anydegreepipeoffset.class);
            startActivity(anydegreepipeoffset);
        } else if (flag == 27) {
            Intent dummysupportvideo = new Intent(mContext, dummysupportvideo.class);
            startActivity(dummysupportvideo);
        } else if (flag == 28) {
            Intent arclengthvideo = new Intent(mContext, arclengthvideo.class);
            startActivity(arclengthvideo);
        } else if (flag == 29) {
            Intent chordlengthvideo = new Intent(mContext, chordlengthvideo.class);
            startActivity(chordlengthvideo);
        } else if (flag == 30) {
            Intent arclengthtochordlengthvideo = new Intent(mContext, arclengthtochordlengthvideo.class);
            startActivity(arclengthtochordlengthvideo);
        } else if (flag == 31) {
            Intent chordlengthtoarclengthvideo = new Intent(mContext, chordlengthtoarclengthvideo.class);
            startActivity(chordlengthtoarclengthvideo);
        } else if (flag == 32) {
            Intent piperollingoffsetvideomenu = new Intent(mContext, piperollingoffsetvideomenu.class);
            startActivity(piperollingoffsetvideomenu);
        } else if (flag == 33) {
            Intent miterbend180degreevideo = new Intent(mContext, miterbend180degreevideo.class);
            startActivity(miterbend180degreevideo);
        } else if (flag == 34) {
            Intent pipeidodcfnpsdnnbvideo = new Intent(mContext, pipeidodcfnpsdnnbvideo.class);
            startActivity(pipeidodcfnpsdnnbvideo);
        } else if (flag == 35) {
            Intent measurementtapekebaremevideo = new Intent(mContext, measurementtapekebaremevideo.class);
            startActivity(measurementtapekebaremevideo);
        } else if (flag == 36) {
            Intent weightcalculationvideo = new Intent(mContext, weightcalculationvideo.class);
            startActivity(weightcalculationvideo);
        } else if (flag == 37) {
            Intent watchmorevideos = new Intent(mContext, watchmorevideos.class);
            startActivity(watchmorevideos);



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
                //        Toast.makeText(mContext, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                    //        Toast.makeText(mContext, "The rewarded ad wasn't ready yet.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                flag = 1;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_liveworkingvideosmenu));
                break;

            case R.id.button2:
                flag = 2;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_diagonalkyahotahai));
                break;

            case R.id.button3:
                flag = 3;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_veryimportantforcolumnfabrication));
                break;

            case R.id.button4:
                flag = 4;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipefitterbasictoadvancevideomenu));
                break;

            case R.id.button5:
                flag = 5;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_learnisometricdrawingvideosmenu));
                break;

            case R.id.button6:
                flag = 6;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_canteleversupportvideomenu));
                break;

            case R.id.button7:
                flag = 7;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_platekarightanglekaisenikalevideomenu));
                break;

            case R.id.button8:
                flag = 8;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_staircasekaisebanayevideosmenu));
                break;

            case R.id.button9:
                flag = 9;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_handrailkaisebanayevideosmenu));
                break;

            case R.id.button10:
                flag = 10;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_reducervideomenu));
                break;

            case R.id.button11:
                flag = 11;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_teebranchvideomenu));
                break;
            case R.id.button12:
                flag = 12;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_howtomakeflangevideomenu));
                break;
           // case R.id.button13:
           //     flag = 13;
            //    startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_platerightangletheory));
            //    break;
            case R.id.button14:
                flag = 14;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_howtomakeconevideomenu));
                break;
            case R.id.button15:
                flag = 15;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_platetoreducer));
                break;
            case R.id.button16:
                flag = 16;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_miterbendvideomenu));
                break;
            case R.id.button17:
                flag = 17;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_rpadkaisebanaye));
                break;
            case R.id.button18:
                flag = 18;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_waterlevelkaisecheckkare));
                break;
            case R.id.button19:
                flag = 19;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_elbowradiusformula));
                break;
            case R.id.button20:
                flag = 20;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_miterbendlayout));
                break;
            case R.id.button21:
                flag = 21;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_typesofhoppervideomenu));
                break;
            case R.id.button22:
                flag = 22;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_ybranchkaisebanayevideomenu));
                break;
            case R.id.button23:
                flag = 23;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_drawingfitterimportantvideomenu));
                break;
            case R.id.button24:
                flag = 24;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_platekatankkaisebnayevideomenu));
                break;
        //    case R.id.button25:
        //        flag = 25;
        //        startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_platekatankkaisebnayevideomenu));
        //        break;
            case R.id.button26:
                flag = 26;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_anydegreepipeoffset));
                break;
            case R.id.button27:
                flag = 27;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_dummysupport));
                break;
            case R.id.button28:
                flag = 28;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_arclength));
                break;
            case R.id.button29:
                flag = 29;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_chordlength));
                break;
            case R.id.button30:
                flag = 30;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_arclengthtochordlength));
                break;
            case R.id.button31:
                flag = 31;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_chordlengthtoarclength));
                break;
            case R.id.button32:
                flag = 32;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_piperollingoffsetvideomenu));
                break;
            case R.id.button33:
                flag = 33;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_miterbend180degree));
                break;
            case R.id.button34:
                flag = 34;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_miterbend180degree));
                break;
            case R.id.button35:
                flag = 35;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_pipeidodcfnpsdnnb));
                break;
            case R.id.button36:
                flag = 36;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_measurementtapekebareme));
                break;
            case R.id.button37:
                flag = 37;
                startLoadingRewardedAd(getResources().getString(R.string.admob_rewarded_id_watchmorevideos));
                break;

            default:
                break;
        }
    }
}
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
import com.fitterkipurijankarisalman.myapplication.databinding.FragmentFtab1Binding;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;

public class ftab1 extends Fragment implements View.OnClickListener {

    private FragmentFtab1Binding binding;
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
        binding = FragmentFtab1Binding.inflate(
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
        binding.button32.setOnClickListener(this);
        binding.button33.setOnClickListener(this);
        binding.button34.setOnClickListener(this);
        binding.button35.setOnClickListener(this);
        binding.button36.setOnClickListener(this);
        binding.button37.setOnClickListener(this);
        binding.button38.setOnClickListener(this);
        binding.button39.setOnClickListener(this);
        binding.button40.setOnClickListener(this);
        binding.button41.setOnClickListener(this);
        binding.button42.setOnClickListener(this);
        binding.button43.setOnClickListener(this);
        binding.button44.setOnClickListener(this);
        binding.button45.setOnClickListener(this);
        binding.button46.setOnClickListener(this);
        binding.button47.setOnClickListener(this);
        binding.button48.setOnClickListener(this);
        binding.button49.setOnClickListener(this);
        binding.button50.setOnClickListener(this);
        binding.button51.setOnClickListener(this);
        binding.button52.setOnClickListener(this);
        binding.button53.setOnClickListener(this);
        binding.button54.setOnClickListener(this);
        binding.button55.setOnClickListener(this);
        binding.button56.setOnClickListener(this);
        binding.button57.setOnClickListener(this);
        binding.button58.setOnClickListener(this);
        binding.button59.setOnClickListener(this);
        binding.button60.setOnClickListener(this);
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
                }
                if (binding.button38.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 38");
                    showSpecificButton(38);
                }
                if (binding.button39.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 39");
                    showSpecificButton(39);
                }
                if (binding.button40.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 40");
                    showSpecificButton(40);
                }
                if (binding.button41.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 41");
                    showSpecificButton(41);
                }
                if (binding.button42.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 42");
                    showSpecificButton(42);}
                if (binding.button43.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 43");
                    showSpecificButton(43);

                }
                if (binding.button44.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 44");
                    showSpecificButton(44);
                }
                if (binding.button45.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 45");
                    showSpecificButton(45);
                }
                if (binding.button46.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 46");
                    showSpecificButton(46);


                }
                if (binding.button47.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 47");
                    showSpecificButton(47);
                }
                if (binding.button48.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 48");
                    showSpecificButton(48);
                }
                if (binding.button49.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 49");
                    showSpecificButton(49);
                }
                if (binding.button50.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 50");
                    showSpecificButton(50);
                }
                if (binding.button51.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 51");
                    showSpecificButton(51);
                }
                if (binding.button52.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 52");
                    showSpecificButton(52);}
                if (binding.button53.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 53");
                    showSpecificButton(53);
                }
                if (binding.button54.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 54");
                    showSpecificButton(54);
                }
                if (binding.button55.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 55");
                    showSpecificButton(55);
                }
                if (binding.button56.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 56");
                    showSpecificButton(56);
                }
                if (binding.button57.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 57");
                    showSpecificButton(57);
                }
                if (binding.button58.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 58");
                    showSpecificButton(58);

                }
                if (binding.button59.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 59");
                    showSpecificButton(59);
                }
                if (binding.button60.getText().toString().toLowerCase().contains(newText)) {
                    Log.w("searchFun", "Show button 59");
                    showSpecificButton(60);


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
        } else if (i == 38) {
            binding.button38.setVisibility(View.VISIBLE);
        } else if (i == 39) {
            binding.button39.setVisibility(View.VISIBLE);
        } else if (i == 40) {
            binding.button40.setVisibility(View.VISIBLE);
        } else if (i == 41) {
            binding.button41.setVisibility(View.VISIBLE);
        } else if (i == 42) {
            binding.button42.setVisibility(View.VISIBLE);
        } else if (i == 43) {
            binding.button43.setVisibility(View.VISIBLE);
        } else if (i == 44) {
            binding.button44.setVisibility(View.VISIBLE);
        } else if (i == 45) {
            binding.button45.setVisibility(View.VISIBLE);
        } else if (i == 46) {
            binding.button46.setVisibility(View.VISIBLE);
        } else if (i == 47) {
            binding.button47.setVisibility(View.VISIBLE);
        } else if (i == 48) {
            binding.button48.setVisibility(View.VISIBLE);
        } else if (i == 49) {
            binding.button49.setVisibility(View.VISIBLE);
        } else if (i == 50) {
            binding.button50.setVisibility(View.VISIBLE);
        } else if (i == 51) {
            binding.button51.setVisibility(View.VISIBLE);
        } else if (i == 52) {
            binding.button52.setVisibility(View.VISIBLE);
        } else if (i == 53) {
            binding.button53.setVisibility(View.VISIBLE);
        } else if (i == 54) {
            binding.button54.setVisibility(View.VISIBLE);
        } else if (i == 55) {
            binding.button55.setVisibility(View.VISIBLE);
        } else if (i == 56) {
            binding.button56.setVisibility(View.VISIBLE);
        } else if (i == 57) {
            binding.button57.setVisibility(View.VISIBLE);
        } else if (i == 58) {
            binding.button58.setVisibility(View.VISIBLE);
        } else if (i == 59) {
            binding.button59.setVisibility(View.VISIBLE);
        } else if (i == 60) {
            binding.button60.setVisibility(View.VISIBLE);

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
        } else if (i == 38) {
            binding.button38.setVisibility(View.GONE);
        } else if (i == 39) {
            binding.button39.setVisibility(View.GONE);
        } else if (i == 40) {
            binding.button40.setVisibility(View.GONE);
        } else if (i == 41) {
            binding.button41.setVisibility(View.GONE);
        } else if (i == 42) {
            binding.button42.setVisibility(View.GONE);
        } else if (i == 43) {
            binding.button43.setVisibility(View.GONE);
        } else if (i == 44) {
            binding.button44.setVisibility(View.GONE);
        } else if (i == 45) {
            binding.button45.setVisibility(View.GONE);
        } else if (i == 46) {
            binding.button46.setVisibility(View.GONE);
        } else if (i == 47) {
            binding.button47.setVisibility(View.GONE);
        } else if (i == 48) {
            binding.button48.setVisibility(View.GONE);
        } else if (i == 49) {
            binding.button49.setVisibility(View.GONE);
        } else if (i == 50) {
            binding.button50.setVisibility(View.GONE);
        } else if (i == 51) {
            binding.button51.setVisibility(View.GONE);
        } else if (i == 52) {
            binding.button52.setVisibility(View.GONE);
        } else if (i == 53) {
            binding.button53.setVisibility(View.GONE);
        } else if (i == 54) {
            binding.button54.setVisibility(View.GONE);
        } else if (i == 55) {
            binding.button55.setVisibility(View.GONE);
        } else if (i == 56) {
            binding.button56.setVisibility(View.GONE);
        } else if (i == 57) {
            binding.button57.setVisibility(View.GONE);
        } else if (i == 58) {
            binding.button58.setVisibility(View.GONE);
        } else if (i == 59) {
            binding.button59.setVisibility(View.GONE);
        } else if (i == 60) {
            binding.button60.setVisibility(View.GONE);

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
        binding.button32.setVisibility(View.GONE);
        binding.button33.setVisibility(View.GONE);
        binding.button34.setVisibility(View.GONE);
        binding.button35.setVisibility(View.GONE);
        binding.button36.setVisibility(View.GONE);
        binding.button37.setVisibility(View.GONE);
        binding.button38.setVisibility(View.GONE);
        binding.button39.setVisibility(View.GONE);
        binding.button40.setVisibility(View.GONE);
        binding.button41.setVisibility(View.GONE);
        binding.button42.setVisibility(View.GONE);
        binding.button43.setVisibility(View.GONE);
        binding.button44.setVisibility(View.GONE);
        binding.button45.setVisibility(View.GONE);
        binding.button46.setVisibility(View.GONE);
        binding.button47.setVisibility(View.GONE);
        binding.button48.setVisibility(View.GONE);
        binding.button49.setVisibility(View.GONE);
        binding.button50.setVisibility(View.GONE);
        binding.button51.setVisibility(View.GONE);
        binding.button52.setVisibility(View.GONE);
        binding.button53.setVisibility(View.GONE);
        binding.button54.setVisibility(View.GONE);
        binding.button55.setVisibility(View.GONE);
        binding.button56.setVisibility(View.GONE);
        binding.button57.setVisibility(View.GONE);
        binding.button58.setVisibility(View.GONE);
        binding.button59.setVisibility(View.GONE);
        binding.button60.setVisibility(View.GONE);

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
        binding.button32.setVisibility(View.VISIBLE);
        binding.button33.setVisibility(View.VISIBLE);
        binding.button34.setVisibility(View.VISIBLE);
        binding.button35.setVisibility(View.VISIBLE);
        binding.button36.setVisibility(View.VISIBLE);
        binding.button37.setVisibility(View.VISIBLE);
        binding.button38.setVisibility(View.VISIBLE);
        binding.button39.setVisibility(View.VISIBLE);
        binding.button40.setVisibility(View.VISIBLE);
        binding.button41.setVisibility(View.VISIBLE);
        binding.button42.setVisibility(View.VISIBLE);
        binding.button43.setVisibility(View.VISIBLE);
        binding.button44.setVisibility(View.VISIBLE);
        binding.button45.setVisibility(View.VISIBLE);
        binding.button46.setVisibility(View.VISIBLE);
        binding.button47.setVisibility(View.VISIBLE);
        binding.button48.setVisibility(View.VISIBLE);
        binding.button49.setVisibility(View.VISIBLE);
        binding.button50.setVisibility(View.VISIBLE);
        binding.button51.setVisibility(View.VISIBLE);
        binding.button52.setVisibility(View.VISIBLE);
        binding.button53.setVisibility(View.VISIBLE);
        binding.button54.setVisibility(View.VISIBLE);
        binding.button55.setVisibility(View.VISIBLE);
        binding.button56.setVisibility(View.VISIBLE);
        binding.button57.setVisibility(View.VISIBLE);
        binding.button58.setVisibility(View.VISIBLE);
        binding.button59.setVisibility(View.VISIBLE);
        binding.button60.setVisibility(View.VISIBLE);


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
            Intent howtomakeelbow = new Intent(mContext, howtomakeelbow.class);
            startActivity(howtomakeelbow);
        } else if (flag == 2) {
            Intent reducerpdfmenu = new Intent(mContext, reducerpdfmenu.class);
            startActivity(reducerpdfmenu);
        } else if (flag == 3) {
            Intent howtomaketeebranch = new Intent(mContext, howtomaketeebranch.class);
            startActivity(howtomaketeebranch);
        } else if (flag == 4) {
            Intent ybranchformula = new Intent(mContext, ybranchformula.class);
            startActivity(ybranchformula);
        } else if (flag == 5) {
            Intent whatiscfidod = new Intent(mContext, whatiscfidod.class);
            startActivity(whatiscfidod);
        } else if (flag == 6) {
            Intent radiusanddiameter = new Intent(mContext, radiusanddiameter.class);
            startActivity(radiusanddiameter);
        } else if (flag == 7) {
            Intent pipeschedulekyahotahai = new Intent(mContext, pipeschedulekyahotahai.class);
            startActivity(pipeschedulekyahotahai);
        } else if (flag == 8) {
            Intent pipekathicknesskyahotahai = new Intent(mContext, pipekathicknesskyahotahai.class);
            startActivity(pipekathicknesskyahotahai);
        } else if (flag == 9) {
            Intent npsdnnbidod = new Intent(mContext, npsdnnbidod.class);
            startActivity(npsdnnbidod);
        } else if (flag == 10) {
            Intent elbowcentercalculation = new Intent(mContext, elbowcentercalculation.class);
            startActivity(elbowcentercalculation);
        } else if (flag == 11) {
            Intent ekcutmemitercutting = new Intent(mContext, ekcutmemitercutting.class);
            startActivity(ekcutmemitercutting);
        } else if (flag == 12) {
            Intent flangekaisefitupkare = new Intent(mContext, flangekaisefitupkare.class);
            startActivity(flangekaisefitupkare);
        } else if (flag == 13) {
            Intent flangemakingformula = new Intent(mContext, flangemakingformula.class);
            startActivity(flangemakingformula);
        } else if (flag == 14) {
            Intent fourtyfivedegreeelbowkaisebanaye = new Intent(mContext, fourtyfivedegreeelbowkaisebanaye.class);
            startActivity(fourtyfivedegreeelbowkaisebanaye);
        } else if (flag == 15) {
            Intent fourtyfivedegreekaelbowkaisefitupkare = new Intent(mContext, fourtyfivedegreekaelbowkaisefitupkare.class);
            startActivity(fourtyfivedegreekaelbowkaisefitupkare);
        } else if (flag == 16) {
            Intent elbowkokisibhidegreemecutting = new Intent(mContext, elbowkokisibhidegreemecutting.class);
            startActivity(elbowkokisibhidegreemecutting);
        } else if (flag == 17) {
            Intent elbowkitneprakarkehotehai = new Intent(mContext, elbowkitneprakarkehotehai.class);
            startActivity(elbowkitneprakarkehotehai);
        } else if (flag == 18) {
            Intent fourtyfivedegreeelbowcenterkaisenikale = new Intent(mContext, fourtyfivedegreeelbowcenterkaisenikale.class);
            startActivity(fourtyfivedegreeelbowcenterkaisenikale);
        } else if (flag == 19) {
            Intent howtofinddegree = new Intent(mContext, howtofinddegree.class);
            startActivity(howtofinddegree);
        } else if (flag == 20) {
            Intent degreemeflangefitupkaisekare = new Intent(mContext, degreemeflangefitupkaisekare.class);
            startActivity(degreemeflangefitupkaisekare);
        } else if (flag == 21) {
            Intent typesofflange = new Intent(mContext, typesofflange.class);
            startActivity(typesofflange);
        } else if (flag == 22) {
            Intent typesofflangeclasses = new Intent(mContext, typesofflangeclasses.class);
            startActivity(typesofflangeclasses);
        } else if (flag == 23) {
            Intent typesofvalve = new Intent(mContext, typesofvalve.class);
            startActivity(typesofvalve);
        } else if (flag == 24) {
            Intent nutboltkebaremejane = new Intent(mContext, nutboltkebaremejane.class);
            startActivity(nutboltkebaremejane);
        } else if (flag == 25) {
            Intent boltkitneprakarkehotehai = new Intent(mContext, boltkitneprakarkehotehai.class);
            startActivity(boltkitneprakarkehotehai);
        } else if (flag == 26) {
            Intent pipesupporting = new Intent(mContext, pipesupporting.class);
            startActivity(pipesupporting);
        } else if (flag == 27) {
            Intent colorsofpipeline = new Intent(mContext, colorsofpipeline.class);
            startActivity(colorsofpipeline);
        } else if (flag == 28) {
            Intent pipekavajankaisenikale = new Intent(mContext, pipekavajankaisenikale.class);
            startActivity(pipekavajankaisenikale);
        } else if (flag == 29) {
            Intent importantmeasurement = new Intent(mContext, importantmeasurement.class);
            startActivity(importantmeasurement);
        } else if (flag == 30) {
            Intent importantshortcut = new Intent(mContext, importantshortcut.class);
            startActivity(importantshortcut);
        } else if (flag == 31) {
            Intent fitterkeliyehandtools = new Intent(mContext, fitterkeliyehandtools.class);
            startActivity(fitterkeliyehandtools);
        } else if (flag == 32) {
            Intent safetytools = new Intent(mContext, safetytools.class);
            startActivity(safetytools);
        } else if (flag == 33) {
            Intent isometricdrawingkipahchan = new Intent(mContext, isometricdrawingkipahchan.class);
            startActivity(isometricdrawingkipahchan);
        } else if (flag == 34) {
            Intent welding = new Intent(mContext, welding.class);
            startActivity(welding);
        } else if (flag == 35) {
            Intent weldingelectrodekeprakar = new Intent(mContext, weldingelectrodekeprakar.class);
            startActivity(weldingelectrodekeprakar);

        } else if (flag == 36) {
            Intent cutting = new Intent(mContext, cutting.class);
            startActivity(cutting);

        } else if (flag == 37) {
            Intent typesofbeam = new Intent(mContext, typesofbeam.class);
            startActivity(typesofbeam);
        } else if (flag == 38) {
            Intent rightangletrick = new Intent(mContext, rightangletrick.class);
            startActivity(rightangletrick);
        } else if (flag == 39) {
            Intent channelmitercuttinganydegree = new Intent(mContext, channelmitercuttinganydegree.class);
            startActivity(channelmitercuttinganydegree);
        } else if (flag == 40) {
            Intent arclength = new Intent(mContext, arclength.class);
            startActivity(arclength);
        } else if (flag == 41) {
            Intent chordlength = new Intent(mContext, chordlength.class);
            startActivity(chordlength);
        } else if (flag == 42) {
            Intent arclengthtochordlength = new Intent(mContext, arclengthtochordlength.class);
            startActivity(arclengthtochordlength);
        } else if (flag == 43) {
            Intent chordtoarclength = new Intent(mContext, chordtoarclength.class);
            startActivity(chordtoarclength);
        } else if (flag == 44) {
            Intent platetopipefabrication = new Intent(mContext, platetopipefabrication.class);
            startActivity(platetopipefabrication);

        } else if (flag == 45) {
            Intent platekavajankaisenikale = new Intent(mContext, platekavajankaisenikale.class);
            startActivity(platekavajankaisenikale);
        } else if (flag == 46) {
            Intent channelkavajankaisenikale = new Intent(mContext, channelkavajankaisenikale.class);
            startActivity(channelkavajankaisenikale);
        } else if (flag == 47) {
            Intent anglekavajankaisenikale = new Intent(mContext, anglekavajankaisenikale.class);
            startActivity(anglekavajankaisenikale);
        } else if (flag == 48) {
            Intent sariyakavajankaisenikale = new Intent(mContext, sariyakavajankaisenikale.class);
            startActivity(sariyakavajankaisenikale);
        } else if (flag == 49) {
            Intent beamkavajankaisenikale = new Intent(mContext, beamkavajankaisenikale.class);
            startActivity(beamkavajankaisenikale);
        } else if (flag == 50) {
            Intent usesofsincostan = new Intent(mContext, usesofsincostan.class);
            startActivity(usesofsincostan);
        } else if (flag == 51) {
            Intent typesofdrawing = new Intent(mContext, typesofdrawing.class);
            startActivity(typesofdrawing);
        } else if (flag == 52) {
            Intent typesofline = new Intent(mContext, typesofline.class);
            startActivity(typesofline);
        } else if (flag == 53) {
            Intent pythagorustheoram = new Intent(mContext, pythagorustheoram.class);
            startActivity(pythagorustheoram);
        } else if (flag == 54) {
            Intent interviewqna = new Intent(mContext, interviewqna.class);
            startActivity(interviewqna);
        } else if (flag == 55) {
            Intent structurefabricationdrawing = new Intent(mContext, structurefabricationdrawing.class);
            startActivity(structurefabricationdrawing);
        } else if (flag == 56) {
            Intent alldrawing = new Intent(mContext, alldrawing.class);
            startActivity(alldrawing);
        } else if (flag == 57) {
            Intent safetyhelmetcolors = new Intent(mContext, safetyhelmetcolors.class);
            startActivity(safetyhelmetcolors);
        } else if (flag == 58) {
            Intent typesofdshackle = new Intent(mContext, typesofdshackle.class);
            startActivity(typesofdshackle);
        } else if (flag == 59) {
            Intent typesofhitches = new Intent(mContext, typesofhitches.class);
            startActivity(typesofhitches);
        } else if (flag == 60) {
            Intent privacypolicy = new Intent(mContext, privacypolicy.class);
            startActivity(privacypolicy);

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
                  //      Toast.makeText(mContext, "Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                  //      Toast.makeText(mContext, "Rewarded Ad failed to load.", Toast.LENGTH_SHORT).show();
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
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_elbowkaisebanaye));
                break;

            case R.id.button2:
                flag = 2;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_reducerkaisebanaye));
                break;

            case R.id.button3:
                flag = 3;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_teebranchkaisebanaye));
                break;

            case R.id.button4:
                flag = 4;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_ybranchkaisebanaye));
                break;

            case R.id.button5:
                flag = 5;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_idodcfkyahotahai));
                break;

            case R.id.button6:
                flag = 6;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_radiusaurdiameter));
                break;

            case R.id.button7:
                flag = 7;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipeschedulekyahotahai));
                break;

            case R.id.button8:
                flag = 8;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipekathicknesskyahotahai));
                break;

            case R.id.button9:
                flag = 9;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_npsdnnbidodkyahotahai));
                break;

            case R.id.button10:
                flag = 10;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_elbowcenterkaisenikale));
                break;

            case R.id.button11:
                flag = 11;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_ekcutmemitercutting));
                break;
            case R.id.button12:
                flag = 12;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_flangekaisefitupkare));
                break;
            case R.id.button13:
                flag = 13;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_platekaflangekaisebanaye));
                break;
            case R.id.button14:
                flag = 14;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_fourtyfivedegreekaelbowkaisebanaye));
                break;
            case R.id.button15:
                flag = 15;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_fourtyfivedegreeelbowfitup));
                break;
            case R.id.button16:
                flag = 16;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_elbowkokisibhidegreemecutting));
                break;
            case R.id.button17:
                flag = 17;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_elbowkitneprakarkehotehai));
                break;
            case R.id.button18:
                flag = 18;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_fourtyfivedegreekaelbowcenterkaisenikale));
                break;
            case R.id.button19:
                flag = 19;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_degreekaisenikale));
                break;
            case R.id.button20:
                flag = 20;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_degreemeflangekaisefitupkare));
                break;
            case R.id.button21:
                flag = 21;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_flangekitneprakarkehotehai));
                break;
            case R.id.button22:
                flag = 22;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_flangekitneclasskehotehai));
                break;
            case R.id.button23:
                flag = 23;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_valvekitneprakarkehotehai));
                break;
            case R.id.button24:
                flag = 24;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_nutboltkebaremejane));
                break;
            case R.id.button25:
                flag = 25;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_boltkitneprakarkehotehai));
                break;
            case R.id.button26:
                flag = 26;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipesupportkeprakar));
                break;
            case R.id.button27:
                flag = 27;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_colorsofpipeline));
                break;
            case R.id.button28:
                flag = 28;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pipekavajankaisenikale));
                break;
            case R.id.button29:
                flag = 29;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_importantmeasurementforfitter));
                break;
            case R.id.button30:
                flag = 30;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_importantshortcutforfitter));
                break;
            case R.id.button31:
                flag = 31;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_fitterhandtool));
                break;
            case R.id.button32:
                flag = 32;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_safetytool));
                break;
            case R.id.button33:
                flag = 33;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_isometricdrawingkipahchan));
                break;
            case R.id.button34:
                flag = 34;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_weldinginformation));
                break;
            case R.id.button35:
                flag = 35;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_weldingelectrodesketypes));
                break;
            case R.id.button36:
                flag = 36;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_cuttinginformation));
                break;
            case R.id.button37:
                flag = 37;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_typesofbeam));
                break;
            case R.id.button38:
                flag = 38;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_rightangletrick));
                break;
            case R.id.button39:
                flag = 39;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_channelmitercuttinganydegree));
                break;
            case R.id.button40:
                flag = 40;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_arclength));
                break;
            case R.id.button41:
                flag = 41;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_chordlength));
                break;
            case R.id.button42:
                flag = 42;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_arctochordlength));
                break;
            case R.id.button43:
                flag = 43;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_chordtoarclength));
                break;




            case R.id.button44:
                flag = 44;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_platetopipefabrication));
                break;
            case R.id.button45:
                flag = 45;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_platekavajankaisenikale));
                break;
            case R.id.button46:
                flag = 46;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_channelkavajankaisenikale));
                break;
            case R.id.button47:
                flag = 47;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_anglekavajankaisenikale));
                break;
            case R.id.button48:
                flag = 48;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_barkavajankaisenikale));
                break;
            case R.id.button49:
                flag = 49;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_beamkavajankaisenikale));
                break;
            case R.id.button50:
                flag = 50;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_sincostankausekaisekare));
                break;
            case R.id.button51:
                flag = 51;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_drawingkitneprakarkehotehai));
                break;
            case R.id.button52:
                flag = 52;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_linekitneprakarkehotehai));
                break;
            case R.id.button53:
                flag = 53;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_pythagorustheoram));
                break;

            case R.id.button54:
                flag = 54;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_interviewqna));
                break;
            case R.id.button55:
                flag = 55;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_structurefabricationdrawing));
                break;
            case R.id.button56:
                flag = 56;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_alldrawing));
                break;
            case R.id.button57:
                flag = 57;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_alldrawing));
                break;
            case R.id.button58:
                flag = 58;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_alldrawing));
                break;
            case R.id.button59:
                flag = 59;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_alldrawing));
                break;
            case R.id.button60:
                flag = 60;
                startLoadingInterstitialAd(getResources().getString(R.string.admob_interstitial_id_alldrawing));
                break;
            default:
                break;
        }
    }
}
package com.fitterkipurijankarisalman.myapplication.activity;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fitterkipurijankarisalman.myapplication.Config;
import com.fitterkipurijankarisalman.myapplication.R;
import com.fitterkipurijankarisalman.myapplication.SubscriptionActivity;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;



import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    TabItem tabItem1, tabItem2, tabItem3, tabItem4;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout1);
        tabItem1 = (TabItem) findViewById(R.id.tab1);
        tabItem2 = (TabItem) findViewById(R.id.tab2);
        tabItem3 = (TabItem) findViewById(R.id.tab3);
        tabItem4 = (TabItem) findViewById(R.id.tab4);
        viewPager = (ViewPager) findViewById(R.id.vpager);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        if (!Config.isPaidUser) {
            if (getRandomNumber(0, 5) == 3) {
                showRemoveAdsDialog();
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void showRemoveAdsDialog() {
        Dialog removeAdsDialog = new Dialog(MainActivity.this);
        removeAdsDialog.setContentView(R.layout.remove_ads_dialog);

        Button removeAdsBtn = removeAdsDialog.findViewById(R.id.remove_ads_main_btn);
        TextView removeAdsMayBeLaterText = removeAdsDialog.findViewById(R.id.remove_ads_later_text);

        removeAdsBtn.setOnClickListener(view -> {
            removeAdsDialog.dismiss();
            startActivity(new Intent(
                    MainActivity.this, SubscriptionActivity.class
            ));
        });

        removeAdsMayBeLaterText.setOnClickListener(view -> removeAdsDialog.dismiss());

        removeAdsDialog.getWindow().setLayout(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        removeAdsDialog.show();
    }

    public static int getRandomNumber(int min, int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }
}
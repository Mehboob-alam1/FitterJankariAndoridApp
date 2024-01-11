package com.fitterkipurijankarisalman.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.billingclient.api.SkuDetails;
import com.fitterkipurijankarisalman.myapplication.billing.BillingClass;
import com.fitterkipurijankarisalman.myapplication.databinding.ActivitySubscriptionBinding;
import com.fitterkipurijankarisalman.myapplication.utils.LoadingDialog;


import java.util.List;

public class SubscriptionActivity extends AppCompatActivity implements BillingClass.BillingErrorHandler, BillingClass.SkuDetailsListener {

    private ActivitySubscriptionBinding binding;
    private BillingClass billingClass;
    private Dialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubscriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadingDialog = LoadingDialog.Companion.initLoadingDialog(this);
        loadingDialog.show();

        binding.backArrow.setOnClickListener(view -> {
            finish();
        });
        binding.noThanksButton.setOnClickListener(view -> {
            finish();
        });

        billingClass = new BillingClass(SubscriptionActivity.this);
        billingClass.setmCallback(this, this);
        billingClass.startConnection();
    }

    @Override
    protected void onDestroy() {
        if (loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
        super.onDestroy();
    }

    @Override
    public void displayErrorMessage(String message) {
        if (message.equals("done")) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadingDialog.dismiss();
                    initClickListeners();
                }
            });
        } else if (message.equals("error")) {
            Toast.makeText(SubscriptionActivity.this, "Error getting billing services", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SubscriptionActivity.this, "Error getting billing services", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getItemSubscriptionStatus(Boolean status) {
    }

    @Override
    public void subscriptionsDetailList(List<SkuDetails> skuDetailsList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < skuDetailsList.size(); i++) {
                    switch (i) {
                        case 0:
                            try {
                                binding.oneMonthPayment.setText(skuDetailsList.get(i).getPrice());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 1:
                            try {
                                binding.oneYearPayment.setText(skuDetailsList.get(i).getPrice());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                binding.sixMonthPayment.setText(skuDetailsList.get(i).getPrice());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        });
    }

    private void initClickListeners() {
        binding.oneMonthLayout.setOnClickListener(view -> {
            try {
                billingClass.purchaseSubscriptionItemByPos(0);
            } catch (Exception e) {
                Toast.makeText(this, "Error getting subscription", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
        binding.sixMonthLayout.setOnClickListener(view -> {
            try {
                billingClass.purchaseSubscriptionItemByPos(1);
            } catch (Exception e) {
                Toast.makeText(this, "Error getting subscription", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
        binding.oneYearLayout.setOnClickListener(view -> {
            try {
                billingClass.purchaseSubscriptionItemByPos(2);
            } catch (Exception e) {
                Toast.makeText(this, "Error getting subscription", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }
}

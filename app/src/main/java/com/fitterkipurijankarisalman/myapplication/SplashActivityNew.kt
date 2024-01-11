package com.fitterkipurijankarisalman.myapplication.activity

import android.content.Intent
import android.content.IntentSender
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.billingclient.api.SkuDetails
import com.fitterkipurijankarisalman.myapplication.Config
import com.fitterkipurijankarisalman.myapplication.R
import com.fitterkipurijankarisalman.myapplication.billing.BillingClass
import com.google.android.material.snackbar.Snackbar
import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.InstallState
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability



class SplashActivityNew : AppCompatActivity(), BillingClass.BillingErrorHandler,
    BillingClass.SkuDetailsListener {

    private var appUpdateManager: AppUpdateManager? = null
    private var installStateUpdatedListener: InstallStateUpdatedListener? = null
    private val IMMEDIATE_APP_UPDATE_REQ_CODE = 123

    private var billingClass: BillingClass? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_new)

        appUpdateManager = AppUpdateManagerFactory.create(applicationContext)
        installStateUpdatedListener = InstallStateUpdatedListener { state: InstallState ->
            when {
                state.installStatus() == InstallStatus.DOWNLOADED -> {
                    popupSnackBarForCompleteUpdate()
                }
                state.installStatus() == InstallStatus.INSTALLED -> {
                    removeInstallStateUpdateListener()
                }
                else -> {
                    //           Toast.makeText(
                    //               applicationContext,
                    //               "InstallStateUpdatedListener: state: " + state.installStatus(),
                    //               Toast.LENGTH_LONG
                    //           ).show()
                }
            }
        }

        appUpdateManager!!.registerListener(installStateUpdatedListener!!)
        checkUpdate()
    }

    private fun checkUpdate() {
        val appUpdateInfoTask = appUpdateManager!!.appUpdateInfo
        appUpdateInfoTask.addOnSuccessListener { appUpdateInfo: AppUpdateInfo ->
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)
            ) {
                startUpdateFlow(appUpdateInfo)
            } else if (appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                startUpdateFlow(appUpdateInfo)
            } else {
                initBilling()
            }
        }
        appUpdateInfoTask.addOnFailureListener {
            initBilling()
        }
    }

    private fun startMainActivity() {
        startActivity(
            Intent(
                this@SplashActivityNew,
                MainActivity::class.java
            )
        )
        finish()
    }

    private fun startUpdateFlow(appUpdateInfo: AppUpdateInfo) {
        try {
            appUpdateManager!!.startUpdateFlowForResult(
                appUpdateInfo,
                AppUpdateType.IMMEDIATE,
                this,
                IMMEDIATE_APP_UPDATE_REQ_CODE
            )
        } catch (e: IntentSender.SendIntentException) {
            e.printStackTrace()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMMEDIATE_APP_UPDATE_REQ_CODE) {
            when (resultCode) {
                RESULT_CANCELED -> {
                    Toast.makeText(
                        applicationContext,
                        "Update canceled by user! Result Code: $resultCode", Toast.LENGTH_LONG
                    ).show()

                    try {//go to playStore
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + applicationContext.packageName)
                        )
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                RESULT_OK -> {
                    Toast.makeText(
                        applicationContext,
                        "Update success!", Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    Toast.makeText(
                        applicationContext,
                        "Update Failed!",
                        Toast.LENGTH_LONG
                    ).show()
                    checkUpdate()
                }
            }
        }
    }

    private fun popupSnackBarForCompleteUpdate() {
        Snackbar.make(
            findViewById(R.id.splash_root),
            "New app is ready!",
            Snackbar.LENGTH_INDEFINITE
        )
            .setAction("Install") { view: View? ->
                if (appUpdateManager != null) {
                    appUpdateManager!!.completeUpdate()
                }
            }
            .setActionTextColor(resources.getColor(R.color.white))
            .show()
    }

    private fun removeInstallStateUpdateListener() {
        if (appUpdateManager != null) {
            appUpdateManager!!.unregisterListener(installStateUpdatedListener!!)
        }
    }

    private fun initBilling() {
        Log.w("asxz", "initBilling: initBilling")
        billingClass = BillingClass(this@SplashActivityNew)
        billingClass!!.setmCallback(this, this)
        billingClass!!.startConnection()
    }

    override fun displayErrorMessage(message: String?) {
        if (message.equals("done")) {
            billingClass!!.isSubscribedToSubscriptionItem()
        } else {
            Config.isPaidUser = false
            startMainActivity()
        }
    }

    override fun getItemSubscriptionStatus(status: Boolean?) {
        Config.isPaidUser = status!!
        startMainActivity()
    }

    override fun subscriptionsDetailList(skuDetailsList: MutableList<SkuDetails>?) {
    }
}
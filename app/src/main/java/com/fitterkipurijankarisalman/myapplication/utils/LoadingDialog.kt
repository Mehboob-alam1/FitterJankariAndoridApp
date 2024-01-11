package com.fitterkipurijankarisalman.myapplication.utils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.fitterkipurijankarisalman.myapplication.R

class LoadingDialog {
    companion object {
        var dialog: Dialog? = null
        fun initLoadingDialog(context: Context): Dialog {
            dialog = Dialog(context)
            val layout = LayoutInflater.from(context).inflate(R.layout.loading_dialog_layout, null)
            dialog!!.apply {
                setContentView(layout)
                setCancelable(false)
                setCanceledOnTouchOutside(false)
                window!!.setBackgroundDrawable(
                    ColorDrawable(Color.TRANSPARENT)
                )
                window!!.setLayout(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            return dialog!!
        }

        fun destroyLoadingDialog() {
            if (dialog != null) {
                if (dialog!!.isShowing) {
                    dialog!!.dismiss()
                }
                dialog = null
            }
        }
    }
}
package com.h5190036.h5190036_yunusemresamat_kotlinfinal.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.appcompat.app.AlertDialog
import com.h5190036.h5190036_yunusemresamat_kotlinfinal.ui.splash.SplashActivity

class AlertDialogUtil {

    fun alertDialog(
        context: Context,
        screen: Class<*>,
        title: String,
        message: String,
        positive: String,
        negative: String
    ) {
        val builder: AlertDialog.Builder =
                context.let { androidx.appcompat.app.AlertDialog.Builder(it) }
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(positive,
            android.content.DialogInterface.OnClickListener { mesaj, i ->
                if (screen == SplashActivity::class.java) {
                    context.startActivity(Intent(Settings.ACTION_SETTINGS))
                    (context as Activity).finish()
                } else {
                    (context as Activity).finish()
                }
            })
        builder.setNegativeButton(negative,
            android.content.DialogInterface.OnClickListener { mesaj, i ->
                if (screen == SplashActivity::class.java) {
                    mesaj.dismiss()
                    (context as Activity).finish()
                } else {
                    mesaj.dismiss()
                }
            })
        builder.show()
    }

}
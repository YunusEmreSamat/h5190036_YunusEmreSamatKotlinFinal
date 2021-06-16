package com.h5190036.h5190036_yunusemresamat_kotlinfinal.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager

class NetworkUtil {

    fun networkKontrol(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return if (networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected) {
            true
        } else {
            false
        }
    }
}
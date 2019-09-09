package com.mani.resumedata.network

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager



class NetWorkConnection {

    /* checks if network is connected
    * @returns true or false status */
    companion object {
        @SuppressLint("MissingPermission")
        fun isNetworkConnected(context: Context): Boolean {

            var connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectionManager.activeNetworkInfo

            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }
}
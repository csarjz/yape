package com.csarjz.domain.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun Context.isConnected(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager ?: return false
    return cm.getNetworkCapabilities(cm.activeNetwork)
        ?.hasCapability((NetworkCapabilities.NET_CAPABILITY_INTERNET))
        ?: false
}

package ferreira.hallefy.easyinvestment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

fun getTimeout(): Int {
    return 120000
}

fun isNetworkAvailable(context: Context): Boolean {
    val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (connectivity == null) {
        return false
    } else {
        val info = connectivity.allNetworkInfo
        if (info != null) {
            for (i in info.indices) {
                if (info[i].state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        }
    }
    return false
}
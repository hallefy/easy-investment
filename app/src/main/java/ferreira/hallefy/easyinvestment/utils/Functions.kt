package ferreira.hallefy.easyinvestment.utils

import android.content.Context
import java.text.NumberFormat
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


fun isNetworkAvailable(context: Context): Boolean {
    val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivity.allNetworkInfo
        if (info != null) {
            for (i in info.indices) {
                if (info[i].state == NetworkInfo.State.CONNECTED) {
                    return true
                }
            }
        }
    return false
}

fun unmask(s: String): String {
    return s.replace("[.]".toRegex(), "").replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "").replace("[(]".toRegex(), "")
            .replace("[)]".toRegex(), "")
}

val DATE_FORMAT = "dd-MM-yyyy"

fun isDateValid(date: String): Boolean {
    return try {
        val df = SimpleDateFormat(DATE_FORMAT)

        df.isLenient = false
        df.parse(date)
        true
    } catch (e: ParseException) {
        false
    }
}
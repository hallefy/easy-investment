package ferreira.hallefy.easyinvestment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


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

fun transformDate(oldDate: String) : String {
        val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val targetFormat = SimpleDateFormat("dd/MM/yyyy")
        val date: Date
        try {
            date = originalFormat.parse(oldDate)

            return targetFormat.format(date)
        } catch (ex: ParseException) {
        }
        return ""
}


fun getDateTime(): String {
    val date = Date()
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    return sdf.format(date)
}

fun diffDate(date: String): Long {
    if (date == null || date.trim { it <= ' ' } == "") {
        return 0
    }

    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val startDate: Date
    val now: Date

    try {
        startDate = sdf.parse(date)
        now = sdf.parse(getDateTime())
        Log.i("hallefy", "now: $now -- start: $startDate")
        var diff = (TimeUnit.MILLISECONDS.toDays(now.time - startDate.time) * -1) - 30
        return diff
    } catch (ex: ParseException) {
    }

    return 0
}

fun String.isInvalidDate(): Boolean {
    return if(this.length == 10){
        var str = this.split("/")

        !validarData(str[0].toInt(), str[1].toInt(), str[2].toInt())

    } else {
        true
    }
}

fun validarData(dia: Int, mes: Int, ano: Int): Boolean {
    return dia in 1..31 && mes > 0 && mes < 13 && ano > 0 &&
            (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 || (mes == 4 || mes == 6 || mes == 9 || mes == 11) &&
                    dia <= 30 || mes == 2 && dia <= 29 && ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0) || dia <= 28)
}
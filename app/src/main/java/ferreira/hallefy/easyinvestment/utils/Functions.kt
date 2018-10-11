package ferreira.hallefy.easyinvestment.utils

import android.content.Context
import java.text.NumberFormat
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.math.BigDecimal
import java.util.*
import java.util.regex.Pattern

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

private val DATE_PATTERN = "(0?[1-9]|1[012]) [/.-] (0?[1-9]|[12][0-9]|3[01]) [/.-] ((19|20)\\d\\d)"

fun validate(date: String): Boolean {
    var pattern: Pattern = Pattern.compile(DATE_PATTERN)

    var matcher = pattern.matcher(date)

    if (matcher.matches()) {
        matcher.reset()

        if (matcher.find()) {
            val day = matcher.group(1)
            val month = matcher.group(2)
            val year = Integer.parseInt(matcher.group(3))

            return if (day == "31" && (month == "4" || month == "6" || month == "9" ||
                            month == "11" || month == "04" || month == "06" ||
                            month == "09")) {
                false // only 1,3,5,7,8,10,12 has 31 days
            } else if (month == "2" || month == "02") {
                //leap year
                if (year % 4 == 0) {
                    !(day == "30" || day == "31")
                } else {
                    !(day == "29" || day == "30" || day == "31")
                }
            } else {
                true
            }
        } else {
            return false
        }
    } else {
        return false
    }
}
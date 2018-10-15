package ferreira.hallefy.easyinvestment.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Handler
import android.text.Editable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import ferreira.hallefy.easyinvestment.R.id.textView
import android.animation.ValueAnimator
import org.w3c.dom.Text


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

fun TextView.startCountAnimation(value: Double) {
    val animator = ValueAnimator.ofFloat(1.toFloat(), value.toFloat())
    animator.duration = 2000
    animator.addUpdateListener { animation -> this.text = "R$" + animation.animatedValue.toString() }
    animator.start()
}

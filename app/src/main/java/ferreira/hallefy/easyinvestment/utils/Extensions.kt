package ferreira.hallefy.easyinvestment.utils

import android.app.Activity
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.text.NumberFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun Activity.goToActivity(destinationClass: Class<*>) {
    var intent = Intent(this, destinationClass)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    this.startActivity(intent)
}

fun Editable.toFormatedAmount() : String {
    return this.toString().replace("R$","")
            .replace(".","")
            .replace(",", ".")
}

fun String.toFormatedDate() : String {
    val originalFormat = SimpleDateFormat("dd/MM/yyyy")
    val targetFormat = SimpleDateFormat("yyyy-MM-dd")
    val date: Date
    try {
        date = originalFormat.parse(this.toString())

        return targetFormat.format(date)
    } catch (ex: ParseException) {
    }
    return ""
}

fun EditText.error(msg: String) {
    this.requestFocus()
    this.error = msg

    this.addTextChangedListener(object : TextWatcher{
        override fun afterTextChanged(p0: Editable?) {}

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            this@error.error = null
        }

    })
}

fun Double.formatMoney() : String {
    val nf = NumberFormat.getCurrencyInstance()
    return nf.format(this).replace("$", "R$")
}

fun EditText.setMoneyMask() {
    this.addTextChangedListener(object: TextWatcher {
        private var current = ""

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (s.toString() != current) {
                this@setMoneyMask.removeTextChangedListener(this)

                var cleanString = s.toString().
                        replace(".", "")
                        .replace(",", "")
                        .replace("R$", "")

                var parsed = cleanString.toDouble()
                var formatted = NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format((parsed / 100))

                current = formatted
                this@setMoneyMask.setText(formatted)
                this@setMoneyMask.setSelection(formatted.length)

                this@setMoneyMask.addTextChangedListener(this)
            }
        }

        override fun afterTextChanged(p0: Editable?) {
        }
    })
}

fun EditText.setDataMask() {
    this.addTextChangedListener(object : TextWatcher {
        var isUpdating: Boolean = false
        var oldTxt = ""
        var mask = "##/##/####"

        override fun onTextChanged(
                s: CharSequence, start: Int, before: Int, count: Int) {

            val str = unmask(s.toString())
            var maskCurrent = ""

            if (isUpdating) {
                oldTxt = str
                isUpdating = false
                return
            }

            var i = 0

            for (m in mask) {
                if (m != '#' && str.length > oldTxt.length) {
                    maskCurrent += m
                    continue
                }
                try {
                    maskCurrent += str[i]
                } catch (e: Exception) {
                    break
                }

                i++
            }
            isUpdating = true
            this@setDataMask.setText(maskCurrent)
            this@setDataMask.setSelection(maskCurrent.length)
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
        }

        override fun afterTextChanged(s: Editable) {}
    })
}

fun EditText.setMaskPercent() {

}

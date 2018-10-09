package ferreira.hallefy.easyinvestment.utils

import android.app.Activity
import android.content.Intent

fun Activity.goToActivity(destinationClass: Class<*>) {
    this.startActivity(Intent(this, destinationClass))
}
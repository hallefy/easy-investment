package ferreira.hallefy.easyinvestiment.utils

import android.app.Activity
import android.content.Intent

fun Activity.goToActivity(destinationClass: Class<*>) {
    this.startActivity(Intent(this, destinationClass))
}
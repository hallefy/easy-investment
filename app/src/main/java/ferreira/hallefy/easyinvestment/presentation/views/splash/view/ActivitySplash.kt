package ferreira.hallefy.easyinvestment.presentation.views.splash.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import ferreira.hallefy.easyinvestment.R
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import ferreira.hallefy.easyinvestment.utils.goToActivity
import kotlinx.android.synthetic.main.activity_splash.*


class ActivitySplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

       Handler().postDelayed({
           goToActivity(ActivityFormulary::class.java)
           this.finish()
        }, 1300)
    }
}



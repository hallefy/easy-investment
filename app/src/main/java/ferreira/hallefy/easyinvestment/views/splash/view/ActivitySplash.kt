package ferreira.hallefy.easyinvestment.views.splash.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ferreira.hallefy.easyinvestment.R
import ferreira.hallefy.easyinvestment.views.formulary.view.ActivityFormulary
import kotlinx.android.synthetic.main.activity_splash.*


class ActivitySplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnIr.setOnClickListener {
            startActivity(Intent(this, ActivityFormulary::class.java))
        }
    }
}



package ferreira.hallefy.easyinvestiment.views.formulary.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ferreira.hallefy.easyinvestiment.R
import ferreira.hallefy.easyinvestiment.views.resultinvestiment.view.ActivityResultInvestiment
import kotlinx.android.synthetic.main.activity_form.*

class ActivityFormulary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
//
//        var skeletonScreen = Skeleton.bind(viewForm)
//                .load(R.layout.form_skeleton)
//                .show()
//
//       Handler().postDelayed({
//            skeletonScreen.hide()
//        }, 2000)

        setUp()
    }

    private fun setUp() {
        initListeners()
    }

    fun initListeners() {

        btnSimular.setOnClickListener {
            startActivity(Intent(this, ActivityResultInvestiment::class.java))
        }
    }
}

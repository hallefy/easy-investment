package ferreira.hallefy.easyinvestment.presentation.views.formulary.view

import android.content.Intent
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ferreira.hallefy.easyinvestment.R
import ferreira.hallefy.easyinvestment.presentation.views.resultinvestiment.view.ActivityResultInvestiment
import kotlinx.android.synthetic.main.activity_form.*

class ActivityFormulary : DaggerAppCompatActivity(), FormularyView {

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
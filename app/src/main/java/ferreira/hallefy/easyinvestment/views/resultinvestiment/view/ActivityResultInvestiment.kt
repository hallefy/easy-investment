package ferreira.hallefy.easyinvestment.views.resultinvestiment.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ferreira.hallefy.easyinvestment.R
import ferreira.hallefy.easyinvestment.views.formulary.view.ActivityFormulary
import kotlinx.android.synthetic.main.activity_invest.*

class ActivityResultInvestiment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invest)

        setUp()
    }

    private fun setUp() {
        initListeners()
    }

    fun initListeners() {

        btnSimularNovamente.setOnClickListener {
            startActivity(Intent(this, ActivityFormulary::class.java))
        }
    }
}

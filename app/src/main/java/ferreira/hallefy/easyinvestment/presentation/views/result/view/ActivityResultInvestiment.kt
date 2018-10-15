package ferreira.hallefy.easyinvestment.presentation.views.result.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ferreira.hallefy.easyinvestment.R
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import ferreira.hallefy.easyinvestment.utils.goToActivity
import ferreira.hallefy.easyinvestment.utils.transformDate
import kotlinx.android.synthetic.main.activity_invest.*

class ActivityResultInvestiment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invest)

        setUp()
    }

    private fun setUp() {
        initListeners()
        getIntentResponse()
    }

    private fun getIntentResponse() {
        var response = intent.getSerializableExtra("response")
        setValues(response as SimulationResponseBusiness)
    }

    private fun setValues(response: SimulationResponseBusiness) {
        tvAmountResult.text = "R$ ${response.investmentParameter.investedAmount}"

        tvGrossAmountProfitTotal.text = "R$ ${response.grossAmountProfit}"
        tvInvestedAmount.text = "R$ ${response.investmentParameter.investedAmount}"
        tvGrossAmount.text = "R$ ${response.grossAmount}"
        tvGrossAmountProfit.text = "R$ ${response.grossAmountProfit}"
        tvTaxesAmount.text = "R$ ${response.taxesAmount}(${response.taxesRate}%)"
        tvNetAmount.text = "R$ ${response.netAmount}"

        tvMaturityDate.text = transformDate(response.investmentParameter.maturityDate)
        tvTotalDays.text = "${response.investmentParameter.maturityTotalDays}"
        tvMonthlyGrossRateProfit.text = "${response.monthlyGrossRateProfit}%"
        tvRate.text = "${response.investmentParameter.rate}%"
        tvAnnualGrossRateProfit.text = "${response.annualGrossRateProfit}%"
        tvRateProfit.text = "${response.rateProfit}%"
    }

    fun initListeners() {

        btnSimularNovamente.setOnClickListener {
            goToActivity(ActivityFormulary::class.java)
        }
    }
}

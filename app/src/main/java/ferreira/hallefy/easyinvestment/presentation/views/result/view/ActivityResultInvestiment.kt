package ferreira.hallefy.easyinvestment.presentation.views.result.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ferreira.hallefy.easyinvestment.R
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import ferreira.hallefy.easyinvestment.utils.formatMoney
import ferreira.hallefy.easyinvestment.utils.goToActivity
import ferreira.hallefy.easyinvestment.utils.transformDate
import kotlinx.android.synthetic.main.activity_result.*

class ActivityResultInvestiment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

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
        tvAmountResult.text = "${response.investmentParameter.investedAmount.formatMoney()}"

        tvGrossAmountProfitTotal.text = "${response.grossAmountProfit.formatMoney()}"
        tvInvestedAmount.text = "${response.investmentParameter.investedAmount.formatMoney()}"
        tvGrossAmount.text = "${response.grossAmount.formatMoney()}"
        tvGrossAmountProfit.text = "${response.grossAmountProfit.formatMoney()}"
        tvTaxesAmount.text = "${response.taxesAmount.formatMoney()}(${response.taxesRate}%)"
        tvNetAmount.text = "${response.netAmount.formatMoney()}"

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

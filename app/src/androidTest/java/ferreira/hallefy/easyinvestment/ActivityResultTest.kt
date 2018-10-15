package ferreira.hallefy.easyinvestment

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import ferreira.hallefy.easyinvestment.domain.model.InvestmentParameterBusiness
import ferreira.hallefy.easyinvestment.domain.model.SimulationResponseBusiness
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import ferreira.hallefy.easyinvestment.presentation.views.result.view.ActivityResultInvestiment
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ActivityResultTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<ActivityResultInvestiment>(ActivityResultInvestiment::class.java, false, false)
    lateinit var simulationResponseBusiness: SimulationResponseBusiness

    @Before
    fun setUp() {
        simulationResponseBusiness = SimulationResponseBusiness(
                InvestmentParameterBusiness(20000.0,
                        200.0,
                        365,
                        15,
                        "16/06/2019",
                        123,
                        false),
                22.0,
                22.0,
                22.0,
                22.0,
                22.0,
                22.0,
                22.0,
                22.0,
                22.0,
                22.0,
        22.0
        )
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testIfFieldsAreShowing() {
        val intent = Intent()
        intent.putExtra("response", simulationResponseBusiness)
        activityRule.launchActivity(intent)
        Intents.init()

        isShowing(R.id.tvAmountResult)
        isShowing(R.id.tvGrossAmountProfitTotal)
        isShowing(R.id.tvInvestedAmount)
        isShowing(R.id.tvGrossAmount)
        isShowing(R.id.tvGrossAmountProfit)
        isShowing(R.id.tvTaxesAmount)
        isShowing(R.id.tvNetAmount)
        isShowing(R.id.tvMaturityDate)
        isShowing(R.id.tvTotalDays)
        isShowing(R.id.tvMonthlyGrossRateProfit)
        isShowing(R.id.tvRate)
        isShowing(R.id.tvAnnualGrossRateProfit)
        isShowing(R.id.tvRateProfit)
    }

    @Test
    fun testIfActivityFormlaryOpen_onClickButton() {
        val intent = Intent()
        intent.putExtra("response", simulationResponseBusiness)
        activityRule.launchActivity(intent)
        Intents.init()

        onView(withId(R.id.btnSimularNovamente)).perform(click())
        IntentMatchers.hasPackage(ActivityFormulary::class.java.`package`.name)
    }

    private fun isShowing(id: Int) {
        onView(withId(id)).check(matches(isDisplayed()))
    }

}
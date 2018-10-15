package ferreira.hallefy.easyinvestment

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ActivityFormularyTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<ActivityFormulary>(ActivityFormulary::class.java, false, true)

    @Before
    fun setUp() {
        Intents.init()
    }

    @Test
    fun testSimulationSuccess() {

        onView(withId(R.id.inputAplicacao)).perform(typeText("200000"))
        onView(withId(R.id.inputDataVencimento)).perform(typeText("16062020"), scrollTo())
        onView(withId(R.id.inputPercentualCdi)).perform(typeText("123"), scrollTo())

        onView(withId(R.id.btnSimular)).perform(click() , scrollTo())
    }

}
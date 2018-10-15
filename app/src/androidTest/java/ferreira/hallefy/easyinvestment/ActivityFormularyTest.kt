package ferreira.hallefy.easyinvestment

import android.content.Context
import android.provider.Settings.Global.getString
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.ActivityResultFunction
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers.hasErrorText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import ferreira.hallefy.easyinvestment.presentation.views.formulary.view.ActivityFormulary
import ferreira.hallefy.easyinvestment.presentation.views.result.view.ActivityResultInvestiment
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock



@RunWith(JUnit4::class)
class ActivityFormularyTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<ActivityFormulary>(ActivityFormulary::class.java, false, true)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testSimulationSuccess() {

        onView(withId(R.id.inputAplicacao)).perform(typeText("200000"))
        onView(withId(R.id.inputDataVencimento)).perform(typeText("16062020"), scrollTo())
        onView(withId(R.id.inputPercentualCdi)).perform(typeText("123"), scrollTo(), closeSoftKeyboard())

        onView(withId(R.id.btnSimular)).perform(click())

        IntentMatchers.hasPackage(ActivityResultInvestiment::class.java.`package`.name)
    }

    @Test
    fun testIfErrorMessagesIsShowed() {
        onView(withId(R.id.btnSimular)).perform(click())

        onView(withId(R.id.inputAplicacao)).check(matches(hasErrorText("Digite um valor maior que 0")))
        onView(withId(R.id.inputAplicacao)).perform(typeText("200000"), closeSoftKeyboard())

        onView(withId(R.id.btnSimular)).perform(click())
        onView(withId(R.id.inputDataVencimento)).check(matches(hasErrorText("Digite uma data válida")))
        onView(withId(R.id.inputDataVencimento)).perform(typeText("16062020"), scrollTo(), closeSoftKeyboard())

        onView(withId(R.id.btnSimular)).perform(click())
        onView(withId(R.id.inputPercentualCdi)).check(matches(hasErrorText("Digite um valor maior que 0")))
        onView(withId(R.id.inputPercentualCdi)).perform(typeText("123"), scrollTo(), closeSoftKeyboard())
    }
}
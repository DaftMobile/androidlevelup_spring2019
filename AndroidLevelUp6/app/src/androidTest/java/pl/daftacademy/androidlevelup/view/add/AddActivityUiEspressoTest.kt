package pl.daftacademy.androidlevelup.view.add

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.home.HomeActivity

@RunWith(AndroidJUnit4::class)
class AddActivityUiEspressoTest {

    @Test
    fun add() {
        ActivityScenario.launch(HomeActivity::class.java)
        Espresso
            .onView(ViewMatchers.withId(R.id.addMovieButton))
            .perform(ViewActions.click())
        Espresso
            .onView(ViewMatchers.withId(R.id.titleEditText))
            .perform(ViewActions.typeText("Pulp Fiction"))
        Espresso
            .onView(ViewMatchers.withId(R.id.yearEditText))
            .perform(ViewActions.typeText("1993"))
        Espresso
            .pressBack()
        Espresso
            .onView(ViewMatchers.withId(R.id.addButton))
            .perform(ViewActions.click())
        Espresso
            .onView(ViewMatchers.withText("Pulp Fiction"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso
            .onView(ViewMatchers.withText("1993"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
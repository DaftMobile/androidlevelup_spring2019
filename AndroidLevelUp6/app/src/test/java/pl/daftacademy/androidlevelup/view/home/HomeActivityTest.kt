package pl.daftacademy.androidlevelup.view.home

import kotlinx.android.synthetic.main.activity_home.*
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import pl.daftacademy.androidlevelup.view.add.AddActivity

@RunWith(RobolectricTestRunner::class)
class HomeActivityTest {

    @Test
    fun `addMovieButton clicks starts AddActivity`() {
        //Arrange
        val activity = Robolectric.setupActivity(HomeActivity::class.java)

        //Act
        activity.addMovieButton.performClick()

        //Assert
        Assert.assertEquals(
            AddActivity::class.java.name,
            Shadows.shadowOf(activity).nextStartedActivity?.component?.className
        )
    }
}
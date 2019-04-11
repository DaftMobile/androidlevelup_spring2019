package pl.daftacademy.androidlevelup.view.add

import android.content.Context
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class AddActivityStarterTest {

    @Test
    fun `getStarterIntent returns intent for AddActivity`() {
        //Arrange
        val context = mock<Context>()

        //Act
        val intent = AddActivityStarter().getStarterIntent(context)

        //Assert
        assertEquals(
            AddActivity::class.java.name,
            intent.component?.className
        )
    }
}
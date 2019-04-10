package pl.daftacademy.androidlevelup.view.viewmodel

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies

class AddViewModelTest {

    private val movies = spy<Movies>()
    private val sut = AddViewModel(movies)

    @Test
    fun `test add is called on movies with proper param`() {
        sut.addMovie("Avengers: Endgame", "2019", listOf("Action"))
        verify(movies).add(listOf(Movie("Avengers: Endgame", 2019, listOf("Action"))))
    }

    @Test
    fun `test add is not called when title is blank`() {
        sut.addMovie("", "2020", emptyList())
        verify(movies, never()).add(any())
    }
}

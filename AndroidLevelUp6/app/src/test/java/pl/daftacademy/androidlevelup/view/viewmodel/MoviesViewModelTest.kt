package pl.daftacademy.androidlevelup.view.viewmodel

import org.junit.Assert
import org.junit.Test
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies

class MoviesViewModelTest {

    private val movie1 = Movie("Movie1", 2010, listOf("Comedy"))
    private val movie2 = Movie("Movie2", 2011, listOf("Horror"))
    private val movies1 = MoviesStub(movie1)
    private val movies2 = MoviesStub(movie2)

    @Test
    fun `test view model returns all available movies from one source`() {
        val sut = MoviesViewModel(movies1)
        Assert.assertEquals(listOf(movie1), sut.getMovies(null))
    }

    @Test
    fun `test view model returns all available movies from multiple sources`() {
        val sut = MoviesViewModel(movies1, movies2)
        Assert.assertEquals(listOf(movie1, movie2), sut.getMovies(null))
    }

    @Test
    fun `test view model returns only films with given genre`() {
        val sut = MoviesViewModel(movies1, movies2)
        Assert.assertEquals(listOf(movie2), sut.getMovies("Horror"))
    }

    private class MoviesStub(private vararg val movies: Movie) : Movies {

        override fun add(movies: Collection<Movie>) = throw UnsupportedOperationException()

        override fun get() = movies.asList()
    }
}

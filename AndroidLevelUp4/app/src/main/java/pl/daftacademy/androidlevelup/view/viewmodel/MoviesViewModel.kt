package pl.daftacademy.androidlevelup.view.viewmodel

import androidx.lifecycle.ViewModel
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies

class MoviesViewModel(private val movies: Movies) : ViewModel() {

    fun getMovies(genre: String?): List<Movie> = if (genre != null) {
        movies.get().filter { genre in it.genres }
    } else {
        movies.get()
    }
}

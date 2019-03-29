package pl.daftacademy.androidlevelup.view.viewmodel

import androidx.lifecycle.ViewModel
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies

class AddViewModel(private val movies: Movies) : ViewModel() {

    fun addMovie(title: String, year: String, genres: List<String>, studio: String) {
        val newMovie = Movie(title, year.toInt(), genres, studio)
        movies.add(listOf(newMovie))
    }
}

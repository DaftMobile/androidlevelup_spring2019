package pl.daftacademy.androidlevelup.view.viewmodel

import androidx.lifecycle.ViewModel
import pl.daftacademy.androidlevelup.entity.Movie

class AddViewModel : ViewModel() {

    fun addMovie(title: String, year: String, genres: List<String>) {
        val newMovie = Movie(title, year.toInt(), genres)
    }
}

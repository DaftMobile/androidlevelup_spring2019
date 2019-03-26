package pl.daftacademy.androidlevelup.view.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.daftacademy.androidlevelup.database.MovieDatabase
import pl.daftacademy.androidlevelup.database.RoomMovies
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.files.AssetsMovies

class ViewModelFactory(application: Application) : ViewModelProvider.Factory {

    private val dbMovies: Movies
    private val assetMovies: Movies

    init {
        MovieDatabase.initIfNeeded(application)
        dbMovies = RoomMovies(MovieDatabase.INSTANCE.movies())
        assetMovies = AssetsMovies(application)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(dbMovies, assetMovies) as T
            }
            modelClass.isAssignableFrom(AddViewModel::class.java) -> {
                AddViewModel(dbMovies) as T
            }
            else -> throw IllegalArgumentException("Unknown view model ${modelClass.simpleName}")
        }
    }
}

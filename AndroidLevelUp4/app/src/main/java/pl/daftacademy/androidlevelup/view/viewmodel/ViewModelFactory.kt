package pl.daftacademy.androidlevelup.view.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pl.daftacademy.androidlevelup.files.MovieFileDao

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> MoviesViewModel(
                MovieFileDao(application)
            ) as T
            else -> throw IllegalArgumentException("Unknown view model ${modelClass.simpleName}")
        }
    }
}

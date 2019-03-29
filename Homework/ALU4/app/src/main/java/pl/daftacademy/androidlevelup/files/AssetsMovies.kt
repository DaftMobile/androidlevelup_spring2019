package pl.daftacademy.androidlevelup.files

import android.content.Context
import com.google.gson.Gson
import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import java.io.InputStreamReader

class AssetsMovies(private val context: Context) : Movies {

    override fun add(movies: Collection<Movie>) = throw UnsupportedOperationException()

    override fun get() = InputStreamReader(context.assets.open("movies.json")).use {
        Gson().fromJson(it, MoviesPage::class.java).movies
    }
}

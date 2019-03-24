package pl.daftacademy.androidlevelup.files

import android.content.Context
import com.google.gson.Gson
import pl.daftacademy.androidlevelup.entity.Movies
import java.io.InputStreamReader

class MovieFileDao(private val context: Context) : Movies {

    override fun get() = InputStreamReader(context.assets.open("movies.json")).use {
        Gson().fromJson(it, MoviesPage::class.java).movies
    }
}

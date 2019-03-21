package pl.daftacademy.androidlevelup.data

import pl.daftacademy.androidlevelup.entity.Movie

interface MovieDao {

    fun getAllMovies(): List<Movie>
}
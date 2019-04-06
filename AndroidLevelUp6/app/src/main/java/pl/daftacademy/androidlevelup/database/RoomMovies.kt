package pl.daftacademy.androidlevelup.database

import pl.daftacademy.androidlevelup.entity.Movie
import pl.daftacademy.androidlevelup.entity.Movies
import pl.daftacademy.androidlevelup.database.Movie as DbMovie

class RoomMovies(private val movieDao: MovieDao) : Movies {

    override fun add(movies: Collection<Movie>) = movieDao.add(movies.map(DbMovie.Companion::fromEntity))

    override fun get(): List<Movie> = movieDao.get().map(DbMovie::toEntity)
}

package pl.daftacademy.androidlevelup.entity

interface Movies {

    fun add(movies: Collection<Movie>)

    fun get(): List<Movie>
}

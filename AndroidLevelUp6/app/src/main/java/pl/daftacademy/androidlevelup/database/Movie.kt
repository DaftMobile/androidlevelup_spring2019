package pl.daftacademy.androidlevelup.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.daftacademy.androidlevelup.entity.Movie

@Entity
class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val year: Int,
    val genres: String
) {
    fun toEntity() = Movie(title, year, genres.split(','))

    companion object {
        fun fromEntity(entity: Movie) = Movie(0, entity.title, entity.year, entity.genres.joinToString(","))
    }
}

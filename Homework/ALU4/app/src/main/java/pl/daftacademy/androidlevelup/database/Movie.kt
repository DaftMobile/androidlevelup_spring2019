package pl.daftacademy.androidlevelup.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(entity = Studio::class, parentColumns = ["id"], childColumns = ["studioId"])
    ]
)
class Movie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val year: Int,
    val genres: String,
    val studioId: Int
)

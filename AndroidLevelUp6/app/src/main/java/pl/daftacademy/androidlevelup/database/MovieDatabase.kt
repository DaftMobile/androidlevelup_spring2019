package pl.daftacademy.androidlevelup.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movies(): MovieDao

    companion object {
        lateinit var INSTANCE: MovieDatabase

        fun initIfNeeded(context: Context) {
            if (MovieDatabase.Companion::INSTANCE.isInitialized.not()) {
                INSTANCE = Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
                    .allowMainThreadQueries()
                    .build()
            }
        }
    }
}

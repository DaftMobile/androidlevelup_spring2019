package pl.daftacademy.androidlevelup.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Studio(@PrimaryKey(autoGenerate = true) val id: Int, val name: String)

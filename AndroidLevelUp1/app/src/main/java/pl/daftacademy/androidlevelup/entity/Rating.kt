package pl.daftacademy.androidlevelup.entity

data class Rating(val aggregateRating: Float,
                  val ratingText: String,
                  val ratingColor: String,
                  val votes: Int)

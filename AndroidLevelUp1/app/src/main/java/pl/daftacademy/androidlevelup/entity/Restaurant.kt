package pl.daftacademy.androidlevelup.entity

import com.google.gson.annotations.SerializedName

data class Restaurant(val id: String,
                      val name: String,
                      val url: String,
                      @SerializedName("featured_image") val imageUrl: String,
                      @SerializedName("photos_url") val photosUrl: String?,
                      @SerializedName("menu_url") val menuUrl: String?,
                      val location: Location,
                      val cuisines: String,
                      val isDeliveringNow: Int,
                      val photoCount: Int,
                      @SerializedName("price_range")  val priceRange: String,
                      @SerializedName("average_cost_for_two") val averageCostForTwo: Int,
                      val currency: String,
                      @SerializedName("user_rating") val rating: Rating
)

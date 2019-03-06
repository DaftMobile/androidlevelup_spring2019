package pl.daftacademy.androidlevelup.api

import pl.daftacademy.androidlevelup.entity.SearchRestaurantsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ZomatoApi {

    @GET("v2.1/search?lat=52.237049&lon=21.017532")
    fun getRestaurantsInWarsaw(@Header("user-key") apiKey: String): Call<SearchRestaurantsResponse>
}
package pl.daftacademy.androidlevelup.api

class ZomatoFetcher {

    private val retrofitProvider by lazy { RetrofitProvider() }
    private val zomatoApi by lazy { retrofitProvider.retrofit.create(ZomatoApi::class.java) }

    fun fetchRestaurantsInWarsaw() = zomatoApi.getRestaurantsInWarsaw(ZOMATO_API_KEY)
}
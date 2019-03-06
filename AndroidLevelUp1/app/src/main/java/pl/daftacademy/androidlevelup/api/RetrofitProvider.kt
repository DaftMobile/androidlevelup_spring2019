package pl.daftacademy.androidlevelup.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import pl.daftacademy.androidlevelup.BuildConfig
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val ZOMATO_API_KEY = ""
const val ZOMATO_BASE_URL = "https://developers.zomato.com/api/"

class RetrofitProvider {

    val retrofit = Retrofit.Builder()
        .baseUrl(ZOMATO_BASE_URL)
        .addConverterFactory(converterFactory)
        .client(okHttpClient)
        .build()

    private val converterFactory: GsonConverterFactory
        get() = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
            .let { GsonConverterFactory.create(it) }

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient.Builder()
            .addLoggingInterceptor(if (BuildConfig.DEBUG) BODY else NONE)
            .build()

    private fun OkHttpClient.Builder.addLoggingInterceptor(level: HttpLoggingInterceptor.Level) =
        addNetworkInterceptor(HttpLoggingInterceptor().setLevel(level))
}

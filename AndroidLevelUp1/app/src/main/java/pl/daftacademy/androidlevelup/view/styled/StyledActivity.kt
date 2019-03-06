package pl.daftacademy.androidlevelup.view.styled

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_restaurant_list.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.api.ZomatoFetcher
import pl.daftacademy.androidlevelup.entity.Restaurant
import pl.daftacademy.androidlevelup.entity.SearchRestaurantsResponse
import pl.daftacademy.androidlevelup.view.styled.recycler.StyledAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StyledActivity : AppCompatActivity() {

    private val zomatoFetcher = ZomatoFetcher()
    private val adapter = StyledAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_list)
        initToolbar()
        initRecyclerView()
        fetchRestaurantsInWarsaw()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Styled Layout"
    }

    private fun initRecyclerView() {
        recyclerView.adapter = adapter
    }

    private fun fetchRestaurantsInWarsaw() {
        zomatoFetcher.fetchRestaurantsInWarsaw().enqueue(object : Callback<SearchRestaurantsResponse> {
            override fun onResponse(call: Call<SearchRestaurantsResponse>, response: Response<SearchRestaurantsResponse>) {
                showRestaurants(response.body()?.restaurants?.map { it.restaurant } ?: emptyList())
            }
            override fun onFailure(call: Call<SearchRestaurantsResponse>, error: Throwable) {
                showError(error)
            }
        })
    }

    private fun showRestaurants(restaurants: List<Restaurant>) {
        progress.visibility = View.GONE
        adapter.items = restaurants
        adapter.notifyDataSetChanged()
    }

    private fun showError(error: Throwable) {
        Toast.makeText(this, error.message ?: error.toString(), Toast.LENGTH_LONG).show()
    }
}

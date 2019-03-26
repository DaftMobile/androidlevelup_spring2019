package pl.daftacademy.androidlevelup.view.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_movies.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.viewmodel.MoviesViewModel
import pl.daftacademy.androidlevelup.view.viewmodel.ViewModelFactory

class MoviesFragment : Fragment() {

    private val viewModel by lazy(::provideViewModel)
    private val adapter = MoviesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_movies, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        val genre = arguments?.getString(GENRE_EXTRA)
        adapter.items = viewModel.getMovies(genre)
    }

    private fun provideViewModel() = ViewModelProviders
        .of(this, ViewModelFactory(requireActivity().application))
        .get(MoviesViewModel::class.java)

    companion object {
        private const val GENRE_EXTRA = "GENRE_EXTRA"

        fun create(genre: String?): MoviesFragment {
            val fragment = MoviesFragment()
            fragment.arguments = Bundle().apply {
                putString(GENRE_EXTRA, genre)
            }
            return fragment
        }
    }
}

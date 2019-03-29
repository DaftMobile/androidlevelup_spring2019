package pl.daftacademy.androidlevelup.view.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_add.*
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.viewmodel.AddViewModel
import pl.daftacademy.androidlevelup.view.viewmodel.ViewModelFactory

class AddActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(
            this,
            ViewModelFactory(application)
        )[AddViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        addButton.setOnClickListener {
            viewModel.addMovie(getMovieTitle(), getMovieYear(), getMovieGenres(), getStudio())
            finish()
        }
    }

    private fun getStudio(): String = studioSpinner.selectedItem as String

    private fun getMovieGenres() = genreChips.children
        .filterIsInstance<Chip>()
        .filter(Chip::isChecked)
        .map(Chip::getText)
        .map(CharSequence::toString)
        .map(String::capitalize)
        .toList()

    private fun getMovieYear() = yearEditText.text.toString()

    private fun getMovieTitle() = titleEditText.text.toString()
}

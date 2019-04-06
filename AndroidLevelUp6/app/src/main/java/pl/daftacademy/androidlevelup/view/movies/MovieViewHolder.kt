package pl.daftacademy.androidlevelup.view.movies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.viewholder_movie.view.*
import pl.daftacademy.androidlevelup.entity.Movie

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(movie: Movie) = with(itemView) {
        txtTitle.text = movie.title
        txtYear.text = movie.year.toString()
        txtGenres.text = movie.genres.joinToString(", ").toLowerCase()
    }
}
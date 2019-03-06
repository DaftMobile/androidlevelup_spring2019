package pl.daftacademy.androidlevelup.view.styled.recycler

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.viewholder_restaurant_styled.view.*
import pl.daftacademy.androidlevelup.entity.Restaurant

class StyledViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    @SuppressLint("SetTextI18n")
    fun bind(item: Restaurant) = with(itemView) {
        setOnClickListener { context.openWebBrowser(item.url) }
        Picasso.get().load(item.imageUrl).into(image)
        changeDetailsVisibility(expand = false)
        arrowUp.setOnClickListener { changeDetailsVisibility(expand = false) }
        arrowDown.setOnClickListener { changeDetailsVisibility(expand = true) }
        name.text = item.name
        avgCostValue.text = "${item.averageCostForTwo} ${item.currency}"
        cuisineValue.text = item.cuisines
        ratingBar.rating = item.rating.aggregateRating
        ratingTxt.text = "${item.rating.aggregateRating} (${item.rating.votes})"
        menu.visibility = if (item.menuUrl.isNullOrBlank()) View.GONE else View.VISIBLE
        menu.setOnClickListener { item.menuUrl?.let { context.openWebBrowser(it) } }
        photos.setOnClickListener { item.photosUrl?.let { context.openWebBrowser(it) } }
        photos.text = item.photoCount.toString()
    }

    private fun View.changeDetailsVisibility(expand: Boolean) {
        arrowDown.visibility = if (expand.not()) View.VISIBLE else View.GONE
        arrowUp.visibility = if (expand) View.VISIBLE else View.GONE
        details.visibility = if (expand) View.VISIBLE else View.GONE
    }

    private fun Context.openWebBrowser(url: String) =
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

}

package pl.daftacademy.androidlevelup.view.styled.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.entity.Restaurant

class StyledAdapter : RecyclerView.Adapter<StyledViewHolder>() {

    var items = emptyList<Restaurant>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StyledViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant_styled, parent, false)
        return StyledViewHolder(view)
    }

    override fun onBindViewHolder(holder: StyledViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}
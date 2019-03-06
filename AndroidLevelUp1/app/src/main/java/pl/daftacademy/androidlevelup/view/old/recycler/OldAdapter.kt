package pl.daftacademy.androidlevelup.view.old.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.entity.Restaurant

class OldAdapter : RecyclerView.Adapter<OldViewHolder>() {

    var items = emptyList<Restaurant>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OldViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant_old, parent, false)
        return OldViewHolder(view)
    }

    override fun onBindViewHolder(holder: OldViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}
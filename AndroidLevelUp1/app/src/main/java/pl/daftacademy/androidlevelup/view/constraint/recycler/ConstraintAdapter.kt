package pl.daftacademy.androidlevelup.view.constraint.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.entity.Restaurant

class ConstraintAdapter : RecyclerView.Adapter<ConstraintViewHolder>() {

    var items = emptyList<Restaurant>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConstraintViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_restaurant_constraint, parent, false)
        return ConstraintViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConstraintViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}
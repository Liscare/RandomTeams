package com.liscare.android.randomteams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.liscare.android.randomteams.R
import com.liscare.android.randomteams.R.id.checkBox
import com.liscare.android.randomteams.model.Player

/**
 * Player adapter for the players list
 *
 * @author Lilian Braud
 */
class PlayerAdapter(private val dataSet: Array<Player>) :
    RecyclerView.Adapter<PlayerAdapter.PlayerHolder>() {

    var onItemClick: ((Boolean, Int) -> Unit)? = null

    /**
     * Player holder
     * Update the dataSet on item click
     */
    inner class PlayerHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout) {

        init {
            itemView.findViewById<CheckBox>(checkBox).setOnClickListener {
                onItemClick?.invoke(itemView.findViewById<CheckBox>(checkBox).isChecked, adapterPosition)
                dataSet[adapterPosition].setSelected(itemView.findViewById<CheckBox>(checkBox).isChecked)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PlayerHolder {
        val linearLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.players_list_line, parent, false) as LinearLayout
        return PlayerHolder(linearLayout)
    }

    /**
     * Init view with dataSet
     */
    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.linearLayout.findViewById<CheckBox>(checkBox).text = dataSet[position].getName()
        holder.linearLayout.findViewById<CheckBox>(checkBox).isChecked = dataSet[position].isSelected()
    }

    override fun getItemCount() = dataSet.size
}

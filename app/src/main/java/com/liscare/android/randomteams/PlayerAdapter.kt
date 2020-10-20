package com.liscare.android.randomteams

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(private val dataSet: Array<Player>) :
    RecyclerView.Adapter<PlayerAdapter.PlayerHolder>() {

    var onItemClick: ((Boolean, Int) -> Unit)? = null

    inner class PlayerHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout) {

        init {
            itemView.findViewById<CheckBox>(R.id.checkBox).setOnClickListener {
                onItemClick?.invoke(itemView.findViewById<CheckBox>(R.id.checkBox).isChecked ,adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PlayerAdapter.PlayerHolder {
        val linearLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.players_list_line, parent, false) as LinearLayout
        return PlayerHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.linearLayout.findViewById<CheckBox>(R.id.checkBox).text = dataSet[position].getName()
    }

    override fun getItemCount() = dataSet.size
}

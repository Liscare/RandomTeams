package com.liscare.android.randomteams.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liscare.android.randomteams.R
import com.liscare.android.randomteams.model.Player

/**
 * Adapter for the list of players in game
 *
 * @author Lilian Braud
 */
class PlayerInGameAdapter(private var dataSet: Array<Player>) :
    RecyclerView.Adapter<PlayerInGameAdapter.PlayerHolder>() {

    inner class PlayerHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout) {

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PlayerHolder {
        val linearLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.player_game_line, parent, false) as LinearLayout
        return PlayerHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        if (dataSet.isNotEmpty()) {
            // A player number start at 1, not at 0 as position
            holder.linearLayout.findViewById<TextView>(R.id.number_player).text = (position + 1).toString()
            holder.linearLayout.findViewById<TextView>(R.id.player_in_game).text = dataSet[position].getName()
            if ((position +1) % 2 == 0) {
                holder.linearLayout.findViewById<View>(R.id.game_divider).visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount() = dataSet.size

    fun setDataSet(dataSet: Array<Player>) {
        this.dataSet = dataSet
    }
}

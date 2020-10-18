package com.liscare.android.randomteams

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    class MyViewHolder(val linearLayout: LinearLayout) : RecyclerView.ViewHolder(linearLayout)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): PlayerAdapter.MyViewHolder {
        val linearLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.players_list_line, parent, false) as LinearLayout

        return MyViewHolder(linearLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.linearLayout.findViewById<CheckBox>(R.id.checkBox).text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size
}

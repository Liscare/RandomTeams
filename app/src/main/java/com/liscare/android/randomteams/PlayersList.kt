package com.liscare.android.randomteams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayersList() : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PlayerAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var counter: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.players_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_playersList_to_home)
        }

        recyclerView = view.findViewById<RecyclerView>(R.id.players_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
        counter = view.findViewById(R.id.text_counter)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewManager = LinearLayoutManager(context)

        viewAdapter = PlayerAdapter(DataBase.getPlayers())
        viewAdapter.onItemClick = {checked, position ->
            DataBase.changeSelectionPlayer(position, checked)
            counter.text = DataBase.getCountSelectedPlayers().toString()
        }
    }

    override fun onResume() {
        super.onResume()
        counter.text = DataBase.getCountSelectedPlayers().toString()
        viewAdapter.notifyDataSetChanged()
    }
}
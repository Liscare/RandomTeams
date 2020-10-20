package com.liscare.android.randomteams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PlayersList : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PlayerAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

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

        recyclerView = view.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSet: Array<Player> = arrayOf(Player("Name 1"),Player("Name 2"), Player("Name 3"))
        viewManager = LinearLayoutManager(context)

        viewAdapter = PlayerAdapter(dataSet)
        viewAdapter.onItemClick = {checked, position ->
            dataSet[position].setSelected(checked)
            // No UI return
        }
    }
}
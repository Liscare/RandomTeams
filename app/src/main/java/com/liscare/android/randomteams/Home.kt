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

/**
 * Default fragment
 * Display the random teams
 *
 * @author Lilian Braud
 */
class Home : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PlayerInGameAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_home_to_playersList)
        }

        recyclerView = view.findViewById<RecyclerView>(R.id.selected_players).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewManager = LinearLayoutManager(context)
        viewAdapter = PlayerInGameAdapter(emptyArray())
    }

    override fun onResume() {
        super.onResume()
        viewAdapter.setDataSet(randPlayers())
        viewAdapter.notifyDataSetChanged()
    }

    /**
     * Assign a random number for each selected player
     * @see Set.random
     */
    private fun randPlayers(): Array<Player> {
        val selectedPlayers = DataBase.getSelectedPlayers()
        val randomPlayers = mutableSetOf<Player>()
        while (randomPlayers.size != selectedPlayers.size) {
            randomPlayers.add(selectedPlayers.random())
        }
        return randomPlayers.toTypedArray()
    }
}
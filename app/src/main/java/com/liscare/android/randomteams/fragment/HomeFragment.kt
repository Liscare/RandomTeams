package com.liscare.android.randomteams.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liscare.android.randomteams.DataBase
import com.liscare.android.randomteams.R
import com.liscare.android.randomteams.adapter.PlayerInGameAdapter
import com.liscare.android.randomteams.model.Player

/**
 * Default fragment
 * Display the random teams
 *
 * @author Lilian Braud
 */
class HomeFragment : Fragment() {

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

        // init RecyclerView
        viewManager = LinearLayoutManager(context)
        viewAdapter =
            PlayerInGameAdapter(
                emptyArray()
            )

        recyclerView = view.findViewById<RecyclerView>(R.id.selected_players).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }
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
        val selectedPlayers =
            DataBase.getSelectedPlayers()
        val randomPlayers = mutableSetOf<Player>()
        while (randomPlayers.size != selectedPlayers.size) {
            randomPlayers.add(selectedPlayers.random())
        }
        return randomPlayers.toTypedArray()
    }
}
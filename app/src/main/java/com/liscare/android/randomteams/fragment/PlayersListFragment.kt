package com.liscare.android.randomteams.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.liscare.android.randomteams.R
import com.liscare.android.randomteams.adapter.PlayerAdapter
import com.liscare.android.randomteams.dao.PlayersDAO
import com.liscare.android.randomteams.model.Player
import com.liscare.android.randomteams.model.PlayersList
import com.liscare.android.randomteams.viewmodel.PlayerViewModel
import com.liscare.android.randomteams.viewmodel.PlayersListViewModel

/**
 * Fragment displaying all players
 * Those players are selectable to create random teams.
 *
 * @author Lilian Braud
 */
class PlayersListFragment() : Fragment(), View.OnClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: PlayerAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var counterView: TextView

    private val playerModel: PlayerViewModel by activityViewModels()
    private val playersListModel: PlayersListViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.players_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Go to Home
        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_playersList_to_home)
        }

        viewManager = LinearLayoutManager(context)

        initAdapter()

        recyclerView = view.findViewById<RecyclerView>(R.id.players_list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        counterView = view.findViewById(R.id.text_counter)

        // Go to EditPlayerFragment
        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            playerModel.select(Player())
            findNavController().navigate(R.id.action_PlayersList_to_editPlayerFragment)
        }

        // Players list
        playersListModel.players.observe(viewLifecycleOwner) {
            viewAdapter.notifyDataSetChanged()
            PlayersDAO.setPlayersList(playersListModel.players.value ?: PlayersList())
        }
    }

    private fun initAdapter() {
        viewAdapter =
            PlayerAdapter(playersListModel.get().toTypedArray())
        // Count selected players on item click
        viewAdapter.onItemClick = { checked, position ->
            playersListModel.get(position)?.setSelected(checked)
            counterView.text = PlayersDAO.countSelectedPlayers().toString()
        }
    }

    override fun onResume() {
        super.onResume()
        counterView.text = PlayersDAO.countSelectedPlayers().toString()
        viewAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        viewAdapter.notifyDataSetChanged()
    }
}
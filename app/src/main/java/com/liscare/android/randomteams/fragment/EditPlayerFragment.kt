package com.liscare.android.randomteams.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.liscare.android.randomteams.R
import com.liscare.android.randomteams.model.Player
import com.liscare.android.randomteams.viewmodel.PlayerViewModel
import com.liscare.android.randomteams.viewmodel.PlayersListViewModel

/**
 * Fragment to edit a player
 * The player can be empty in case it is a new one.
 *
 * @author Lilian Braud
 */
class EditPlayerFragment : Fragment() {

    /** Containing the current player */
    private val playerViewModel: PlayerViewModel by activityViewModels()

    /** Containing all players */
    private val playersListModel: PlayersListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_player_fragment, container, false)
    }

    /**
     * Init the UI with the player name
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerViewModel.selectedPlayer.observe(viewLifecycleOwner) { item: Player ->
            view.findViewById<EditText>(R.id.edit_name).setText(item.getName())
        }

        // Save player and go to PlayersList
        view.findViewById<Button>(R.id.save_player).setOnClickListener {
            playerViewModel.selectedPlayer.value?.setName(view.findViewById<EditText>(R.id.edit_name).text.toString())
            playersListModel.add(playerViewModel.selectedPlayer.value ?: Player())
            findNavController().navigate(R.id.action_editPlayerFragment_to_PlayersList)
        }
    }
}
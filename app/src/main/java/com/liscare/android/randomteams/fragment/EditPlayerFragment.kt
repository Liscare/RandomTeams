package com.liscare.android.randomteams.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.liscare.android.randomteams.R
import com.liscare.android.randomteams.model.Player
import com.liscare.android.randomteams.viewmodel.PlayerViewModel
import com.liscare.android.randomteams.viewmodel.PlayersListViewModel
import java.util.*

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

        val nameEditText = view.findViewById<EditText>(R.id.edit_name)
        val savePlayerButton = view.findViewById<Button>(R.id.save_player)

        playerViewModel.selectedPlayer.observe(viewLifecycleOwner, { item: Player ->
            nameEditText.setText(item.getName())
            savePlayerButton.isEnabled = item.getName().length > 2
        })

        // Save player and go to PlayersList
        savePlayerButton.setOnClickListener {
            playerViewModel.selectedPlayer.value?.setName(
                nameEditText.text.toString().capitalize(
                    Locale.getDefault()
                )
            )
            playersListModel.add(playerViewModel.selectedPlayer.value ?: Player())
            findNavController().navigate(R.id.action_editPlayerFragment_to_PlayersList)
        }

        // Disable save button when the name text is too short
        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Empty
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                savePlayerButton.isEnabled = !(s.isNullOrBlank() || s.length <= 2)
            }

            override fun afterTextChanged(s: Editable?) {
                // Empty
            }
        })
    }
}

package com.liscare.android.randomteams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import com.google.android.material.snackbar.Snackbar

/**
 * Fragment to edit a player
 * The player can be empty in case it is a new one.
 *
 * @author Lilian Braud
 */
class EditPlayerFragment : Fragment() {

    /** Containing the current player */
    private val playerViewModel: PlayerViewModel by activityViewModels()

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

        view.findViewById<Button>(R.id.save_player).setOnClickListener {
            Snackbar.make(it, "Do nothing", Snackbar.LENGTH_LONG).show()
        }
    }
}
package com.liscare.android.randomteams.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liscare.android.randomteams.model.Player

/**
 * View Model for one player
 *
 * @author Lilian Braud
 * @see Player
 */
class PlayerViewModel : ViewModel() {

    /** Selected player to edit it*/
    var selectedPlayer = MutableLiveData<Player>()

    /**
     *  Select a player to edit or create
     */
    fun select(player: Player) {
        selectedPlayer.value = player
    }
}
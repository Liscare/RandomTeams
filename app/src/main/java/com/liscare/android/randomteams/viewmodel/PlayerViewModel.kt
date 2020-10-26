package com.liscare.android.randomteams.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liscare.android.randomteams.model.Player

/**
 * View Model for one player
 * @see Player
 */
class PlayerViewModel : ViewModel() {

    var selectedPlayer = MutableLiveData<Player>()

    fun select(player: Player) {
        selectedPlayer.value = player
    }
}
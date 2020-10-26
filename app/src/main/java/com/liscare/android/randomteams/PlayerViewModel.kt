package com.liscare.android.randomteams

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlayerViewModel : ViewModel() {

    var selectedPlayer = MutableLiveData<Player>()

    fun select(player: Player) {
        selectedPlayer.value = player
    }
}
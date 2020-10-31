package com.liscare.android.randomteams.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liscare.android.randomteams.Database
import com.liscare.android.randomteams.model.Player
import com.liscare.android.randomteams.model.PlayersList

/**
 * View model for all available players (aka players list)
 *
 * @author Lilian Braud
 * @see Player
 */
class PlayersListViewModel : ViewModel() {

    /**
     * List of available players (selected or not)
     * @see MutableLiveData
     */
    var players = MutableLiveData<PlayersList>()

    /**
     * Get the entire list from Database singleton
     */
    init {
        players.value = Database.getPlayersList()
    }

    /**
     * Add a player into the general list
     *
     * @param player New player in the list
     */
    fun add(player: Player) {
        players.value?.getPlayers()?.add(player)
    }

    fun get(position: Int): Player? {
        return players.value?.getPlayers()?.get(position)
    }

    fun get(): MutableList<Player> {
        return players.value?.getPlayers() ?: emptyList<Player>().toMutableList()
    }
}
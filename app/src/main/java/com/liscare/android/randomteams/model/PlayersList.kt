package com.liscare.android.randomteams.model

import kotlinx.serialization.Serializable

/**
 * Group of players
 *
 * @author Lilian Braud
 */
@Serializable
data class PlayersList (private var name: String = "", private var players: MutableList<Player> = emptyList<Player>().toMutableList()) {

    fun getPlayers(): MutableList<Player> {
        return players
    }
}
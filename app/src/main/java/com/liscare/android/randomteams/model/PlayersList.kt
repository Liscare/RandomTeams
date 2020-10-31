package com.liscare.android.randomteams.model

/**
 * Group of players
 *
 * @author Lilian Braud
 */
data class PlayersList (private var name: String = "", private var players: MutableList<Player> = emptyList<Player>().toMutableList()) {

    fun getPlayers(): MutableList<Player> {
        return players
    }
}
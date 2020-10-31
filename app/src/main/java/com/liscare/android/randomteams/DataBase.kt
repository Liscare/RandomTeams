package com.liscare.android.randomteams

import android.content.Context
import com.liscare.android.randomteams.model.Player
import com.liscare.android.randomteams.model.PlayersList

/**
 * Singleton for database composed of all players
 *
 * @author Lilian Braud
 */
object DataBase {

    private var playersList: PlayersList = PlayersList()

    private lateinit var context: Context;

    /**
     * Count the number of players selected
     *
     * @param players List of players
     * @return Number of players selected
     */
    fun getCountSelectedPlayers(players: List<Player>?): Int {
        var count = 0
        for (playerInGame in players ?: return 0) {
            if (playerInGame.isSelected()) {
                count++
            }
        }
        return count
    }

    fun setPlayersList(playersList: PlayersList) {
        this.playersList = playersList
    }

    fun getPlayersList(): PlayersList {
        return playersList
    }

    fun getPlayers(): List<Player> {
        return playersList.getPlayers()
    }

    fun setContext(context: Context) {
        this.context = context
    }
}
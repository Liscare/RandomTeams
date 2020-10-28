package com.liscare.android.randomteams

import com.liscare.android.randomteams.model.Player

/**
 * Singleton for database composed of all players
 *
 * @author Lilian Braud
 */
object DataBase {

    private val players: Array<Player> = Array(11) {
        Player("Nom $it")
    }

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

    fun getPlayers(): Array<Player> {
        return players
    }
}
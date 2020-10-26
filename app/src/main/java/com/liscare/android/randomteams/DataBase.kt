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
     * @return Number of players selected
     */
    fun getCountSelectedPlayers(): Int {
        var count = 0
        for (playerInGame in players) {
            if (playerInGame.isSelected()) {
                count++
            }
        }
        return count
    }

    /**
     * Change the state Selected of a player
     *
     * @param index Index of the player
     * @param selected If this player is selected in the list
     */
    fun changeSelectionPlayer(index: Int, selected: Boolean ) {
        players[index].setSelected(selected)
    }

    /**
     * Return the list of selected players
     */
    fun getSelectedPlayers(): Array<Player> {
        val selectedPlayers: MutableList<Player> = mutableListOf<Player>()
        for(player in players) {
            if (player.isSelected()) {
                selectedPlayers.add(player)
            }
        }
        return selectedPlayers.toTypedArray()
    }

    fun getPlayers(): Array<Player> {
        return players
    }
}
package com.liscare.android.randomteams

/**
 * Singleton for database composed of all players
 *
 * @author Lilian Braud
 */
object DataBase {

    private val players: Array<Player> = Array(11) {Player("Nom $it")}

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

    fun getPlayers(): Array<Player> {
        return players
    }
}
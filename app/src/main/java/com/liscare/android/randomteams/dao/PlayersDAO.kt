package com.liscare.android.randomteams.dao

import com.liscare.android.randomteams.Database
import com.liscare.android.randomteams.model.Player
import com.liscare.android.randomteams.model.PlayersList

object PlayersDAO {

    fun getPlayersList(): PlayersList = Database.getPlayersList()

    fun getSelectedPlayers(): List<Player> = Database.getPlayersList().getPlayers().filter { player ->  player.isSelected()}

    fun countSelectedPlayers(): Int {
        return Database.getPlayersList().getPlayers().count { player -> player.isSelected() }
    }

    fun addPlayer(player: Player) {
        Database.getPlayersList().getPlayers().add(player)
        Database.commit()
    }

    fun setPlayersList(playersList: PlayersList) {
        Database.setPlayersList(playersList)
        Database.commit()
    }
}

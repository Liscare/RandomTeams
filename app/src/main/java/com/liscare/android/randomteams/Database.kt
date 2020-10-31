package com.liscare.android.randomteams

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.liscare.android.randomteams.model.Player
import com.liscare.android.randomteams.model.PlayersList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Singleton for database composed of all players
 *
 * @author Lilian Braud
 */
object Database {

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

    fun save() {
        context.openFileOutput("my_players_group.json", FragmentActivity.MODE_PRIVATE).use {
            it.write(Json.encodeToString(getPlayersList()).toByteArray())
        }
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
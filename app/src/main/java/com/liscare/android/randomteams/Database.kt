package com.liscare.android.randomteams

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.liscare.android.randomteams.model.PlayersList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Singleton for database composed of all players
 *
 * @author Lilian Braud
 */
object Database {

    private const val FILE_NAME: String = "my_players_group.json"

    /** List of players, empty by default */
    private var playersList: PlayersList = PlayersList()

    /** Activity context */
    private lateinit var context: Context;

    fun commit() {
        context.openFileOutput(FILE_NAME, FragmentActivity.MODE_PRIVATE).use {
            it.write(Json.encodeToString(getPlayersList()).toByteArray())
        }
    }

    fun setPlayersList(playersList: PlayersList) {
        this.playersList = playersList
    }

    fun getPlayersList(): PlayersList {
        return playersList
    }

    fun setContext(context: Context) {
        this.context = context
    }
}
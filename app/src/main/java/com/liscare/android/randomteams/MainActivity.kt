package com.liscare.android.randomteams

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentActivity
import com.liscare.android.randomteams.dao.PlayersDAO
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/**
 * Main activity
 * Init the Database
 *
 * @author Lilian Braud
 * @see Database
 */
class MainActivity : FragmentActivity() {

    private val fileName: String = "my_players_group.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Read saved players
        if (applicationContext.fileList().contains(fileName)) {
            Database.setContext(applicationContext)
            applicationContext.openFileInput(fileName).bufferedReader().useLines {
                PlayersDAO.setPlayersList(Json.decodeFromString(it.joinToString("")))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
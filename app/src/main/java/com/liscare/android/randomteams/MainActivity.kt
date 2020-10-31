package com.liscare.android.randomteams

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentActivity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Main activity
 * Innit the Database
 *
 * @author Lilian Braud
 * @see Database
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        if (applicationContext.fileList().contains("my_players_group.json")) { // Read saved players
            Database.setContext(applicationContext)
            applicationContext.openFileInput("my_players_group.json").bufferedReader().useLines {
                Database.setPlayersList(Json.decodeFromString(it.joinToString("")))
            }
        } else { // Create an empty file
            applicationContext.openFileOutput("my_players_group.json", Context.MODE_PRIVATE)
                .use {
                    it.write(Json.encodeToString(Database.getPlayersList()).toByteArray())
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
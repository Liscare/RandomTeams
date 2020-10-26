package com.liscare.android.randomteams

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.FragmentActivity

/**
 * Main activity
 * For now, it is a default activity
 *
 * @author Lilian Braud
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
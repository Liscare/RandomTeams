package com.liscare.android.randomteams.model

/**
 * Player model
 * A player is someone who can be selected to play
 *
 * @author Lilian Braud
 */
class Player (private var name: String = "", private var selected: Boolean = false) {

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun isSelected(): Boolean {
        return selected
    }

    fun setSelected(selected: Boolean) {
        this.selected = selected
    }
}
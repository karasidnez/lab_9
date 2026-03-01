package com.timonin.lab_9.data

import com.timonin.lab_9.R
import com.timonin.lab_9.model.Game

class Datasource {
    fun loadGameList(): List<Game> {
        return listOf(
            Game(R.string.game1, R.string.game1_description, R.drawable.game1),
            Game(R.string.game2, R.string.game2_description, R.drawable.game2),
            Game(R.string.game3, R.string.game3_description, R.drawable.game3),
            Game(R.string.game4, R.string.game4_description, R.drawable.game4),
            Game(R.string.game5, R.string.game5_description, R.drawable.game5),
            Game(R.string.game6, R.string.game6_description, R.drawable.game6),
            Game(R.string.game7, R.string.game7_description, R.drawable.game7),
            Game(R.string.game8, R.string.game8_description, R.drawable.game8),
            Game(R.string.game9, R.string.game9_description, R.drawable.game9),
            Game(R.string.game10, R.string.game10_description, R.drawable.game10)
        )
    }
}
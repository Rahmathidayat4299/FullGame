package com.example.fullgame.controller

import android.util.Log


class Controller(private val callback: Callback) : InterfaceController {
    override fun check(
        hasilPlayerSatu: String,
        hasilPlayerDua: String,
        playerSatu: String?,
        com: String
    ) {
        if (hasilPlayerSatu == hasilPlayerDua) {
//            callback.checkGame(R.string.Draw, R.color.white, R.drawable.bg_draw)
            callback.checkGame("Draw")
        } else if ((hasilPlayerSatu == "batu") && (hasilPlayerDua == "gunting") || (hasilPlayerSatu == "gunting") && (hasilPlayerDua == "kertas") || (hasilPlayerSatu == "kertas") && (hasilPlayerDua == "batu")) {
//            callback.checkGame(R.string.player1, R.color.white, R.drawable.bg_win)
            callback.checkGame("$playerSatu win")
        } else {
//            callback.checkGame(R.string.comMenang, R.color.white, R.drawable.bg_win)
            callback.checkGame("$com  win")
            Log.d("hasil", "$playerSatu VS $hasilPlayerDua")
        }


    }
}
package com.example.fullgame.gamesuwit

import android.util.Log
import com.example.fullgame.R


class Controller(private val callback: Callback) : InterfaceController {


    override fun check(playerSatu: CharSequence, com: CharSequence) {
        if (playerSatu == com) {
            callback.checkGame(R.string.Draw, R.color.white, R.drawable.bg_draw)
        } else if ((playerSatu == "batu") && (com == "gunting") || (playerSatu == "gunting") && (com == "kertas") || (playerSatu == "kertas") && (com == "batu")) {
            callback.checkGame(R.string.winplayer1, R.color.white, R.drawable.bg_win)
        } else if ((com == "batu") && (playerSatu == "gunting") || (com == "gunting") && (playerSatu == "kertas") || (com == "kertas") && (com == "playerSatu")) {
            callback.checkGame(R.string.comMenang, R.color.white, R.drawable.bg_win)
            Log.d("hasil", "$playerSatu VS $com")
        }
    }
}
package com.example.gamesuwit

import android.util.Log
import com.example.fullgame.R


class Controller(private val callback: Callback) : InterfaceController {



    override fun check(playerSatu: CharSequence, com: CharSequence) {
        if (playerSatu == com) {
//            tv_VS.text = "Draw"
            callback.checkGame(R.string.Draw,R.color.white,R.drawable.bg_draw)
//            tvVS.setBackgroundResource(R.drawable.bg_draw)
//            tvVS.setText(R.string.Draw)
//            tvVS.setTextColor(getColor(R.color.white))

        } else if ((playerSatu == "batu") && (com == "gunting") || (playerSatu == "gunting") && (com == "kertas") || (playerSatu == "kertas") && (com == "batu")) {

            callback.checkGame(R.string.winplayer1,R.color.white,R.drawable.bg_win)
////          tv_VS.text = "Player 1 menang"
//            tvVS.setBackgroundResource(R.drawable.bg_win)
//            tvVS.setText(R.string.winplayer1)
//            tvVS.setTextColor(getColor(R.color.white))


        } else {
            callback.checkGame(R.string.comMenang,R.color.white,R.drawable.bg_win)
//            tvVS.setBackgroundResource(R.drawable.bg_win)
//            tvVS.setText(R.string.comMenang)
//            tvVS.setTextColor(getColor(R.color.white))


        }
        Log.d("hasil", "$playerSatu VS $com")
    }
}
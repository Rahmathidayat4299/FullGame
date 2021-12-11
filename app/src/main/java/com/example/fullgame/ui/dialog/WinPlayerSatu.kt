package com.example.fullgame.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.fullgame.R
import com.example.fullgame.ui.CallbackDialog
import com.example.fullgame.ui.com.ComActivity
import java.lang.Exception


class WinPlayerSatu :  DialogFragment() {
    private  var  callDialog : CallbackDialog? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_win_player_satu, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMainLagi = view.findViewById<Button>(R.id.btn_main)
        val btnMenu = view.findViewById<Button>(R.id.btn_menu)
        val tvresult = view.findViewById<TextView>(R.id.tvWinPlayer1)

        if (arguments != null) {
            val hasil = arguments?.getString("winner", "")

            tvresult.text = hasil
        }

//        btnMainLagi.setOnClickListener {
//            dismiss()
//        }
        btnMainLagi.setOnClickListener {
            dismiss()
            callDialog?.resetGame(android.R.color.transparent,"","")

        }

        btnMenu.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            callDialog = context as CallbackDialog
        }catch (e: Exception){
            e.printStackTrace()
        }
    }


}
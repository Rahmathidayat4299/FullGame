package com.example.fullgame.ui.player

import android.content.pm.ActivityInfo
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.fullgame.R
import com.example.fullgame.controller.Callback
import com.example.fullgame.controller.Controller
import com.example.fullgame.databinding.ActivityPlayerBinding
import com.example.fullgame.controller.CallbackDialog
import com.example.fullgame.ui.dialog.WinPlayerSatu

class PlayerActivity : AppCompatActivity(), Callback, CallbackDialog {
    private lateinit var binding: ActivityPlayerBinding
    var hasilPlayerSatu = ""
    var hasilPlayerDua = ""

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivClose.setOnClickListener {
            finishAffinity()
        }

        val messagePlayer = intent.getStringExtra("this player")
        val comPlayer = findViewById<TextView>(R.id.player1).apply {
            text = messagePlayer
        }


        val playerSatu = arrayOf(
            binding.batup1,
            binding.guntingp1,
            binding.kertasp1
        )
        val playerDua = arrayOf(
            binding.batuCom,
            binding.kertasCom,
            binding.guntingCom
        )


        val controller = Controller(this)

        playerSatu.forEachIndexed { index, ImageView ->

            ImageView.setOnClickListener {
                hasilPlayerSatu = playerSatu[index].contentDescription.toString()
                conditionClick(false)
                conditionClickP2(true)
                if (hasilPlayerDua != "") {
                    controller.check(hasilPlayerSatu, hasilPlayerDua, messagePlayer, "playerDua")
                }


                playerSatu.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                playerSatu[index].setBackgroundResource(R.drawable.bg_image)


            }
        }
        playerDua.forEachIndexed { index, ImageView ->
            ImageView.setOnClickListener {


                hasilPlayerDua = playerDua[index].contentDescription.toString()
                Toast.makeText(this, "Pemain dua memilih $hasilPlayerDua", Toast.LENGTH_SHORT)
                    .show()
                conditionClickP2(false)

                if (hasilPlayerSatu != "") {
                    controller.check(hasilPlayerSatu, hasilPlayerDua, messagePlayer, "playerDua")
                }

                playerDua.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                playerDua[index].setBackgroundResource(R.drawable.bg_image)
            }
        }





        binding.btnReset.setOnClickListener {
            hasilPlayerSatu = ""
            hasilPlayerDua = ""
            resetGame(android.R.color.transparent, "", "")

        }
    }

    private fun conditionClick(isEnable: Boolean) {
        binding.batup1.isEnabled = isEnable
        binding.kertasp1.isEnabled = isEnable
        binding.guntingp1.isEnabled = isEnable
    }

    private fun conditionClickP2(isEnable: Boolean) {
        binding.batuCom.isEnabled = isEnable
        binding.kertasCom.isEnabled = isEnable
        binding.guntingCom.isEnabled = isEnable
    }


    @RequiresApi(Build.VERSION_CODES.M)
    override fun checkGame(checkGame: String) {
        val resultDialog = WinPlayerSatu()
        val bundle = Bundle()
        bundle.putString("winner", checkGame)
        resultDialog.arguments = bundle
        resultDialog.show(supportFragmentManager, "DialogResult")

    }

    override fun resetGame(bg: Int, hasilPemainSatu: String, hasilPemainDua: String) {
        binding.batuCom.setBackgroundResource(bg)
        binding.kertasCom.setBackgroundResource(bg)
        binding.guntingCom.setBackgroundResource(bg)
        binding.batup1.setBackgroundResource(bg)
        binding.kertasp1.setBackgroundResource(bg)
        binding.guntingp1.setBackgroundResource(bg)
        conditionClick(true)
        conditionClickP2(false)
        hasilPlayerSatu = ""
        hasilPlayerDua = ""
    }

}



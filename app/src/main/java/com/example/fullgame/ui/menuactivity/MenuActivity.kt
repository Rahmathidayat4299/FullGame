package com.example.fullgame.ui.menuactivity


import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.fullgame.R
import com.example.fullgame.ui.com.ComActivity
import com.example.fullgame.ui.player.PlayerActivity
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val messageSnackbar = intent.getStringExtra("this message")

        Snackbar.make(
            findViewById<ConstraintLayout>
                (R.id.menuActivty), "Selamat Datang $messageSnackbar", Snackbar.LENGTH_SHORT
        ).setAction(
            "Tutup"
        ) {

        }.show()

        val message = intent.getStringExtra("this message")
        val namePlayer = findViewById<TextView>(R.id.tvPemain).apply {
            text = message
        }
        val messageCom = intent.getStringExtra("this message")
        val com = findViewById<TextView>(R.id.playerCom).apply {
            text = messageCom
        }

        val playerVsCom = findViewById<ImageView>(R.id.ivCom)
        val playerVsplayer = findViewById<ImageView>(R.id.ivPemain)

        playerVsplayer.setOnClickListener{
            sendMessagePlayer()
        }

        playerVsCom.setOnClickListener {
            sendMessageCom()
        }
    }

    private fun sendMessageCom() {
        val com = findViewById<TextView>(R.id.playerCom)
        val namePlayer = com.text.toString()
        val intent = Intent(this, ComActivity::class.java).also {
            it.putExtra("this player", namePlayer)
            startActivity(it)
        }
    }
    private fun sendMessagePlayer() {
        val com = findViewById<TextView>(R.id.tvPemain)
        val namePlayer = com.text.toString()
        val intent = Intent(this, PlayerActivity::class.java).also {
            it.putExtra("this player", namePlayer)
            startActivity(it)
        }

    }



}
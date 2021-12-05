package com.example.fullgame


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.fullgame.gamesuwit.ComActivity
import com.example.fullgame.gamesuwit.PlayerActivity
import com.google.android.material.snackbar.Snackbar

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        Snackbar.make(findViewById<ConstraintLayout>
            (R.id.menuActivty),"Selamat Datang ",Snackbar.LENGTH_SHORT).setAction(
            "Tutup"){

            }.show()

        val message = intent.getStringExtra("this message")
        val namePlayer = findViewById<TextView>(R.id.tvPemain).apply{
            text = message
        }
        val messageCom = intent.getStringExtra("this message")
        val com = findViewById<TextView>(R.id.playerCom).apply{
            text = messageCom
        }

        val playerVsCom = findViewById<ImageView>(R.id.ivCom)
        playerVsCom.setOnClickListener {
            val mIntent = Intent(this,ComActivity::class.java)
            startActivity(mIntent)

        }
        val playerVsplayer = findViewById<ImageView>(R.id.ivPemain)
        playerVsplayer.setOnClickListener {
            val mIntent = Intent(this, PlayerActivity::class.java)
            startActivity(mIntent)

        }



    }
}
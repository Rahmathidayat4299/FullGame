package com.example.fullgame.gamesuwit

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.fullgame.R
import com.example.fullgame.databinding.ActivityPlayerBinding

class PlayerActivity : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityPlayerBinding
//    private lateinit var batup1: ImageView
//    private lateinit var guntingp1: ImageView
//    private lateinit var kertasp1: ImageView
//    private lateinit var batuCom: ImageView
//    private lateinit var kertasCom: ImageView
//    private lateinit var guntingCom: ImageView
//    private lateinit var tvVS: TextView
//    private lateinit var btnReset: Button

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val messagePlayer = intent.getStringExtra("this player")
        val comPlayer = findViewById<TextView>(R.id.player1).apply{
            text = messagePlayer
        }


//        batup1 = findViewById(R.id.batup1)
//        guntingp1 = findViewById(R.id.guntingp1)
//        kertasp1 = findViewById(R.id.kertasp1)
//
//        batuCom = findViewById(R.id.batuCom)
//        kertasCom = findViewById(R.id.kertasCom)
//        guntingCom = findViewById(R.id.guntingCom)
//        tvVS = findViewById(R.id.tvVS)
//        btnReset = findViewById(R.id.btnReset)

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
            Log.e("pemain satu","klikk")
            ImageView.setOnClickListener {
                val hasilPemain = playerSatu[index].contentDescription.toString()
                conditionClick(false)

                playerSatu.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                playerSatu[index].setBackgroundResource(R.drawable.bg_image)

                playerDua.forEachIndexed { index, ImageView ->
                    ImageView.setOnClickListener {

                        val hasilPemainDua = playerDua[index].contentDescription.toString()
                        conditionClickP2(false)
                        controller.check(playerSatu[index].contentDescription.toString(),
                   playerDua[index].contentDescription.toString())
                        playerDua.forEach {
                            it.setBackgroundResource(android.R.color.transparent)
                        }
                        playerDua[index].setBackgroundResource(R.drawable.bg_image)
                    }
                }
            }
        }


//        playerSatu.forEachIndexed { index, imageView ->
//            imageView.setOnClickListener {
//                controller.check(
//                    playerSatu[index].contentDescription.toString(),
//                    playerDua[index].contentDescription.toString()
//                )
//
//                playerDua[index].setBackgroundResource(R.drawable.bg_image)
////                notklikPemain(batup1, guntingp1, kertasp1)
//                conditionClick(false)
//                playerSatu.forEach {
//                    it.setBackgroundResource(android.R.color.transparent)
//                }
//                playerSatu[index].setBackgroundResource(R.drawable.bg_image)
//
//            }
//
//
//
//
//        }




        binding.btnReset.setOnClickListener {
            playerSatu.forEach {
                it.setBackgroundResource(android.R.color.transparent)
                conditionClick(true)

            }
//            trueklikPemain(batup1, guntingp1, kertasp1)
            playerDua.forEach {
                it.setBackgroundResource(android.R.color.transparent)
                conditionClickP2(true)
            }
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
    override fun checkGame(text: Int, background: Int, textColor: Int) {
        binding.tvVS.text = getString(text)
        binding.tvVS.setBackgroundColor(getColor(background))
        binding.tvVS.setTextColor(textColor)
    }

}
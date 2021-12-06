package com.example.fullgame.gamesuwit

//import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.fullgame.R
import com.example.fullgame.databinding.ActivityComBinding

class ComActivity : AppCompatActivity(), Callback {
    private lateinit var binding: ActivityComBinding


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get dataa nama player from MenuActivity
        val messagePlayer = intent.getStringExtra("this player")
        val comPlayer = findViewById<TextView>(R.id.player1Com).apply{
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
        val com = arrayOf(
            binding.batuCom,
            binding.kertasCom,
            binding.guntingCom
        )

        val controller = Controller(this)


        playerSatu.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val pilihanCom = com.random()
                controller.check(
                    playerSatu[index].contentDescription.toString(),
                    pilihanCom.contentDescription.toString()
                )

                pilihanCom.setBackgroundResource(R.drawable.bg_image)
//                notklikPemain(batup1, guntingp1, kertasp1)
                conditionClick(false)
                playerSatu.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                playerSatu[index].setBackgroundResource(R.drawable.bg_image)
            }
        }



        binding.btnReset.setOnClickListener {
            playerSatu.forEach {
                it.setBackgroundResource(android.R.color.transparent)
            }
//            trueklikPemain(batup1, guntingp1, kertasp1)
            com.forEach {
                it.setBackgroundResource(android.R.color.transparent)
                conditionClick(true)
            }
        }
    }

    private fun conditionClick(isEnable: Boolean) {
        binding.batup1.isEnabled = isEnable
        binding.kertasp1.isEnabled = isEnable
        binding.guntingp1.isEnabled = isEnable
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun checkGame(text: Int, background: Int, textColor: Int) {
        binding.tvVS.text = getString(text)
        binding.tvVS.setBackgroundColor(getColor(background))
        binding.tvVS.setTextColor(textColor)
    }


//    private fun controlGame(playerSatu: CharSequence, com: CharSequence) {
//        if (playerSatu == com) {
////            tv_VS.text = "Draw"
//            tvVS.setBackgroundResource(R.drawable.bg_draw)
//            tvVS.setText(R.string.Draw)
//            tvVS.setTextColor(getColor(R.color.white))
//
//        } else if ((playerSatu == batup1.contentDescription) && (com == guntingCom.contentDescription) || (playerSatu == guntingp1.contentDescription) && (com == kertasCom.contentDescription) || (playerSatu == kertasp1.contentDescription) && (com == batuCom.contentDescription)) {
//
//
////            tv_VS.text = "Player 1 menang"
//            tvVS.setBackgroundResource(R.drawable.bg_win)
//            tvVS.setText(R.string.winplayer1)
//            tvVS.setTextColor(getColor(R.color.white))
//
//
//        } else {
//            tvVS.setBackgroundResource(R.drawable.bg_win)
//            tvVS.setText(R.string.comMenang)
//            tvVS.setTextColor(getColor(R.color.white))
//
//
//        }
//        Log.d("hasil", "$playerSatu VS $com")


//    }

//    private fun notklikPemain(gunting: ImageView, kertas: ImageView, batu: ImageView) {
//        batu.isEnabled = false
//        gunting.isEnabled = false
//        kertas.isEnabled = false
//
//    }
//
//    private fun trueklikPemain(gunting: ImageView, kertas: ImageView, batu: ImageView) {
//        batu.isEnabled = true
//        gunting.isEnabled = true
//        kertas.isEnabled = true
//
//    }


}
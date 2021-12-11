package com.example.fullgame.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.fullgame.R
import com.example.fullgame.ui.menuactivity.MenuActivity


class ThirdFragment : Fragment() {
    private lateinit var fillText: EditText
    private lateinit var btnName: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = view.findViewById<ImageView>(R.id.ivThird)
        Glide.with(view)
            .load("https://raw.githubusercontent.com/Rahmathidayat4299/AssetGambar/master/landing-page3.png")
            .into(image)
        Toast.makeText(requireContext(), "make toast", Toast.LENGTH_SHORT).show()
        fillText = view.findViewById(R.id.editText)
        btnName = view.findViewById(R.id.btnName)

        fillText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                btnName.isVisible = s.toString().trim().isNotEmpty()

            }
        })
        btnName.setOnClickListener {
            val Intent = Intent(activity, MenuActivity::class.java)
            startActivity(Intent)
        }

        btnName.setOnClickListener {
            sendMessage()
        }

    }

    private fun sendMessage(){
        val namePlayer = fillText.text.toString()
        val intent = Intent(activity, MenuActivity::class.java).also {
            it.putExtra("this message",namePlayer)
            startActivity(it)
        }

//        val intent2 = Intent(activity,ComActivity::class.java).also {
//            it.putExtra("this message",namePlayer)
//            startActivity(it)
//        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)


    }


}



package com.example.fullgame.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.fullgame.R


class FirstFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = view.findViewById<ImageView>(R.id.first)

        Glide.with(view)
            .load("https://raw.githubusercontent.com/Rahmathidayat4299/AssetGambar/master/landing-page1.png")
            .into(image)
        Toast.makeText(requireContext(), "make toast", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?

    ): View? {
//         Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


}
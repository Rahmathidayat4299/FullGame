package com.example.fullgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.fullgame.adapters.ViewPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import me.relex.circleindicator.CircleIndicator3

class MainActivity() : AppCompatActivity() {


    private var imageDesc = mutableListOf<String>()
    private var imageViewpage = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewpager2 = findViewById<ViewPager2>(R.id.view_pager_2)
        viewpager2.adapter = ViewPagerAdapter(this.supportFragmentManager, lifecycle)
        val indicator : CircleIndicator3 = findViewById(R.id.indicator)
        indicator.setViewPager(viewpager2)

    }


}








package com.example.fullgame.ui.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.fullgame.R
import com.example.fullgame.adapters.ViewPagerAdapter
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








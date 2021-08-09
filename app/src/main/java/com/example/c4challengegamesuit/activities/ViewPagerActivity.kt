package com.example.c4challengegamesuit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.c4challengegamesuit.R
import com.example.c4challengegamesuit.adapter.ViewPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class ViewPagerActivity : AppCompatActivity() {
    private val next by lazy { findViewById<ImageView>(R.id.ivArrow) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        // ViewPager2
        val springDotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
        val viewPager2 = findViewById<ViewPager2>(R.id.vp2)
        viewPager2.adapter = ViewPagerAdapter(this.supportFragmentManager, lifecycle)
        springDotsIndicator.setViewPager2(viewPager2)
    }
}
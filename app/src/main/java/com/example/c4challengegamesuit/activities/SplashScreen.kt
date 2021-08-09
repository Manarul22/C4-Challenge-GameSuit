package com.example.c4challengegamesuit.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.c4challengegamesuit.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashTime: Long = 3000

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTime)
    }
}
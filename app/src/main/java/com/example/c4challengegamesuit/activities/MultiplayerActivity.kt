package com.example.c4challengegamesuit.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.c4challengegamesuit.interfaces.Callback2
import com.example.c4challengegamesuit.R
import com.example.c4challengegamesuit.controllers.Controller2
import com.example.c4challengegamesuit.fragments.MenuDialogFragment

class MultiplayerActivity : AppCompatActivity(), Callback2 {
    // Gets Id by findViewById
    private val batu by lazy { findViewById<ImageView>(R.id.batuPlayer) }
    private val kertas by lazy { findViewById<ImageView>(R.id.kertasPlayer) }
    private val gunting by lazy { findViewById<ImageView>(R.id.guntingPlayer) }
    private val rock by lazy { findViewById<ImageView>(R.id.batuCom) }
    private val paper by lazy { findViewById<ImageView>(R.id.kertasCom) }
    private val scissors by lazy { findViewById<ImageView>(R.id.guntingCom) }
    private val versus by lazy { findViewById<ImageView>(R.id.imgVersus) }
    private val reset by lazy { findViewById<ImageView>(R.id.imgRefresh) }
    private val imgUrl by lazy { findViewById<ImageView>(R.id.imgJudul) }
    private val message by lazy { intent.getStringExtra("name") }
    private val pemain by lazy { findViewById<TextView>(R.id.tvPemain) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplayer)
        // Mengganti Nama Player1
        pemain.text = "$message"
        // Permission image form Url
        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(imgUrl)
        val controller2 = Controller2(this)
        val dataChoicePlayer1 = arrayListOf(batu, kertas, gunting)
        val dataChoicePlayer2 = arrayListOf(rock, paper, scissors)
        val choice = arrayListOf("batu", "kertas", "gunting")

        // Menentukan Pilihan Player1 dan Player2
        dataChoicePlayer1.forEachIndexed {index1, imageView1 ->
            imageView1.setOnClickListener {
                for (item in dataChoicePlayer1) {
                    if (item == dataChoicePlayer1[index1])
                        item.setBackgroundResource(R.drawable.select)
                    else item.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                }
                Toast.makeText(this, "$message memilih ${choice[index1]}", Toast.LENGTH_SHORT).show()
                dataChoicePlayer2.forEachIndexed {index2, imageView2 ->
                    imageView2.setOnClickListener {
                        for (item in dataChoicePlayer2) {
                            if (item == dataChoicePlayer2[index2])
                                item.setBackgroundResource(R.drawable.select)
                            else item.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                        }
                        Toast.makeText(this, "Player2 memilih ${choice[index2]}", Toast.LENGTH_SHORT).show()
                        controller2.checkWinnerMultiplayer(index1, index2)
                    }
                }
            }
        }

        reset.setOnClickListener {
            this.resetGame()
            Log.d("Main", "All Reset")
        }
    }

    private fun resetGame() {
        val dataImage = arrayListOf(batu, kertas, gunting, rock, paper, scissors)
        versus.setImageResource(R.drawable.vs)
        dataImage.forEach {
            it.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    override fun showWinnerMultiplayer(resultWinnerMultiplayer: Int) {
        when (resultWinnerMultiplayer) {
            0 -> MenuDialogFragment.newInstance("  $message \nMENANG!").show(supportFragmentManager, null)
            1 -> MenuDialogFragment.newInstance(" $message \nKALAH!").show(supportFragmentManager, null)
            else -> MenuDialogFragment.newInstance("SERI!").show(supportFragmentManager, null)
        }
    }
}
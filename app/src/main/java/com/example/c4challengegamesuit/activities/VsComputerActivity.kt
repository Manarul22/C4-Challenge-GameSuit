package com.example.c4challengegamesuit.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.c4challengegamesuit.interfaces.Callback
import com.example.c4challengegamesuit.controllers.Controller
import com.example.c4challengegamesuit.R
import com.example.c4challengegamesuit.fragments.MenuDialogFragment

class  VsComputerActivity : AppCompatActivity(), Callback {

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
        setContentView(R.layout.activity_main)
        // Mengganti Nama Player
        pemain.text = "$message"
        // Permission image form Url
        Glide.with(this).load("https://i.ibb.co/HC5ZPgD/splash-screen1.png").into(imgUrl)
        val controller = Controller(this)
        val dataChoicePlayer = arrayListOf(batu, kertas, gunting)
        val dataRandomCom = arrayListOf(rock, paper, scissors)
        val choice = controller.vsCom

        // Menentukan Pilihan Player dan Random Pilihan Computer
        dataChoicePlayer.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                for (item in dataChoicePlayer) {
                    if (item == dataChoicePlayer[index])
                        item.setBackgroundResource(R.drawable.select)
                    else item.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                }
                val comPlay = (0..2).random()
                for (item in dataRandomCom) {
                    if (item == dataRandomCom[comPlay])
                        item.setBackgroundResource(R.drawable.select)
                    else item.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                }
                controller.checkWinnerVsCom(choice[index], choice[comPlay])
                Toast.makeText(this, "Player memilih ${choice[index]}", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Computer memilih ${choice[comPlay]}", Toast.LENGTH_SHORT).show()
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

    override fun showWinnerVsCpu(resultWinnerVsCpu: Int) {
        when (resultWinnerVsCpu) {
            0 -> MenuDialogFragment.newInstance("  $message \nMENANG!").show(supportFragmentManager, null)
            1 -> MenuDialogFragment.newInstance(" $message \nKALAH!").show(supportFragmentManager, null)
            else -> MenuDialogFragment.newInstance("SERI!").show(supportFragmentManager, null)
        }
    }
}




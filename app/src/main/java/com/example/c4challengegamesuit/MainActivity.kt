package com.example.c4challengegamesuit


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), Callback {

    // Gets Id by findViewById
    private val batu by lazy { findViewById<ImageView>(R.id.batuPlayer) }
    private val kertas by lazy { findViewById<ImageView>(R.id.kertasPlayer) }
    private val gunting by lazy { findViewById<ImageView>(R.id.guntingPlayer) }
    private val rock by lazy { findViewById<ImageView>(R.id.batuCom) }
    private val paper by lazy { findViewById<ImageView>(R.id.kertasCom) }
    private val scissors by lazy { findViewById<ImageView>(R.id.guntingCom) }
    private val versus by lazy { findViewById<ImageView>(R.id.imgVersus) }
    private val reset by lazy { findViewById<ImageView>(R.id.imgRefresh) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = Controller(this)
        val dataChoicePlayer = arrayListOf(batu, kertas, gunting)
        val dataRandomCom = arrayListOf(rock, paper, scissors)

        /** - Kode ImageView pada saat click ini sama
         *  - Harus dibuat reusable
            - Kesimpulan jika kode yang dipakai konsepnya sama makan buat reusable */

        dataChoicePlayer.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                for (item in dataChoicePlayer) {
                    if (item == dataChoicePlayer[index])
                        item.setBackgroundResource(R.drawable.select)
                    else item.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                }
                val comPlay = (0..2).random()
                for (item in dataRandomCom) {
                    if (item == dataRandomCom)
                        item.setBackgroundResource(R.drawable.select)
                    else item.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                }
                controller.checkWinner(index.plus(1), comPlay)
                Log.d("Main", "$comPlay Selected")
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

    override fun showWinner(resultWinner: Int) {
        when (resultWinner) {
            0 -> versus.setImageResource(R.drawable.p1menang)
            1 -> versus.setImageResource(R.drawable.p2menang)
            else -> versus.setImageResource(R.drawable.draw)
        }
    }
}



package com.example.c4challengegamesuit.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.c4challengegamesuit.R
import com.google.android.material.snackbar.Snackbar

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val message = intent.getStringExtra("name")

        val nameVsPemain = "$message VS Pemain"
        findViewById<TextView>(R.id.tvEditPemain).text = nameVsPemain
        val nameVsCpu = "$message VS CPU"
        findViewById<TextView>(R.id.tvEditCpu).text = nameVsCpu

        val multiplayer = findViewById<ImageView>(R.id.ivLanding1)
        val vsCom = findViewById<ImageView>(R.id.ivLanding2)

        val snackBar = message?.let {
            Snackbar.make(
                multiplayer,
                "Selamat Datang $it",
                Snackbar.LENGTH_LONG
            )
        }

        snackBar?.setAction("Tutup") {
            snackBar.dismiss()
        }
        snackBar?.show()

        multiplayer.setOnClickListener {
            val intent = Intent(this, MultiplayerActivity::class.java)
            intent.putExtra("name", message)
            startActivity(intent)
        }
        vsCom.setOnClickListener {
            val intent = Intent(this, VsComputerActivity::class.java)
            intent.putExtra("name", message)
            startActivity(intent)
        }


    }
}
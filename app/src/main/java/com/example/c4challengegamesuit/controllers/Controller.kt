package com.example.c4challengegamesuit.controllers

import com.example.c4challengegamesuit.interfaces.Callback


class Controller(private val listener: Callback) {
    /** Game logic - gets image pemain dengan value dan cek image com
    player & com
    0:rock
    1:paper
    2:scissors */
    val vsCom = arrayListOf("batu", "kertas", "gunting")
    fun checkWinnerVsCom(player: String, com: String) {
        when {
            // Player Win Logic
            player == vsCom[0] && com == vsCom[2] ||
                    player == vsCom[1] && com == vsCom[0] ||
                    player == vsCom[2] && com == vsCom[1] -> listener.showWinnerVsCpu(0)
            // Com Win Logic
            player == vsCom[0] && com == vsCom[1] ||
                    player == vsCom[1] && com == vsCom[2] ||
                    player == vsCom[2] && com == vsCom[0] -> listener.showWinnerVsCpu(1)
            // Draw Logic
            else -> listener.showWinnerVsCpu(2)
        }
    }

}
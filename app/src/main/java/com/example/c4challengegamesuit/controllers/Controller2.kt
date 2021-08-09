package com.example.c4challengegamesuit.controllers

import com.example.c4challengegamesuit.interfaces.Callback2

class Controller2(private val listener2: Callback2) {
    fun checkWinnerMultiplayer(player1: Int, player2: Int) {
        when {
            // Player1 Win
            player1 == 0 && player2 == 2 ||
                    player1 == 1 && player2 == 0 ||
                    player1 == 2 && player2 == 1 -> listener2.showWinnerMultiplayer(0)
            // Player1 Lose
            player1 == 2 && player2 == 0 ||
                    player1 == 0 && player2 == 1 ||
                    player1 == 1 && player2 == 2 -> listener2.showWinnerMultiplayer(1)
            // Draw
            else -> listener2.showWinnerMultiplayer(2)
        }
    }
}
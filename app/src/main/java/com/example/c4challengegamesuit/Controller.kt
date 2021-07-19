package com.example.c4challengegamesuit


class Controller(private val listener: Callback) {
    /** Game logic - gets image pemain dengan value dan cek image com
    player           com
    1: rock          0:rock
    2: paper         1:paper
    3: scissors      2:scissors */
    fun checkWinner(player: Int, com: Int) {
        when {
            player == 1 && com == 0 ||
                    player == 2 && com == 1 ||
                    player == 2 && com == 2 -> listener.showWinner(2)
            player == 1 && com == 2 ||
                    player == 2 && com == 0 ||
                    player == 3 && com == 1 -> listener.showWinner(0)
            else -> listener.showWinner(1)
        }
    }

    fun clickBatu() {

    }

}
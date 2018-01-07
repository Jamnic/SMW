package game.main

import javax.swing.SwingUtilities

fun main(args: Array<String>) {
    SwingUtilities.invokeLater {
        try {
            GameWindow()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
package game.time

import game.main.GamePanel

class Timer(
        private val drawablePanel: GamePanel,
        private val tickable: Tickable
) : Runnable {

    companion object {
        private val SECOND =    1000

        private val TPS = 60
        private val FPS = 120

        private val ticks = SECOND / TPS
        private val frames = SECOND / FPS
    }

    override fun run() {
        var previousTickTime = System.currentTimeMillis()
        var previousFrameTime = System.currentTimeMillis()

        while (true) {
            val currentTime = System.currentTimeMillis()

            if (previousTickTime + ticks <= currentTime) {
                tickable.tick()
                previousTickTime = currentTime
            }

            if (previousFrameTime + frames <= currentTime) {
                drawablePanel.repaint()
                previousFrameTime = currentTime
            }
        }
    }
}
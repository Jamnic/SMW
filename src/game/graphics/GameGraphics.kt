package game.graphics

import game.unit.Rect
import java.awt.Graphics

class GameGraphics(
        private val graphics: Graphics
) {

    fun draw(image: Image, rect: Rect) {
        graphics.drawImage(
                image.bufferedImage(),
                rect.position.x().toInt(),
                rect.position.y().toInt(),
                null)
    }
}
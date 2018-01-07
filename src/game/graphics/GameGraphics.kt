package game.graphics

import game.unit.Position
import java.awt.Graphics

class GameGraphics(
        private val graphics: Graphics
) {

    fun draw(image: Image, position: Position) {
        graphics.drawImage(
                image.bufferedImage(),
                position.x().toInt(),
                position.y().toInt(),
                null)
    }
}
package game.drawable

import game.graphics.GameGraphics
import game.graphics.Image
import game.unit.Position

class ImageSprite(
        private val image: Image,
        private val position: Position = Position()
) : Drawable {

    override fun draw(graphics: GameGraphics) {
        graphics.draw(image, position)
    }
}
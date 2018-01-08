package game.drawable

import game.graphics.GameGraphics
import game.graphics.Image
import game.unit.Rect

class ImageSprite(
        private val image: Image,
        private val rect: Rect
) : Drawable {

    override fun draw(graphics: GameGraphics) {
        graphics.draw(image, rect)
    }
}
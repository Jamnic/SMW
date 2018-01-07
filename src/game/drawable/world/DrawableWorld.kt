package game.drawable.world

import game.domain.world.World
import game.drawable.Drawable
import game.drawable.ImageSprite
import game.graphics.GameGraphics
import game.graphics.Image

class DrawableWorld(
        image: Image,
        private val worldDelegate: World,
        private val drawableDelegate: Drawable = ImageSprite(image)
) : World by worldDelegate,
        Drawable by drawableDelegate {

    override fun draw(graphics: GameGraphics) {
        drawableDelegate.draw(graphics)

        worldDelegate.sprites()
                .filter { it is Drawable }
                .map { it as Drawable }
                .forEach { it.draw(graphics) }
    }
}
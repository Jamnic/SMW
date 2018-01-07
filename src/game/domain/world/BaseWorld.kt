package game.domain.world

import game.domain.block.ImmovableSprite
import game.domain.sprite.Sprite

class BaseWorld(
        private val sprites: MutableList<Sprite> = mutableListOf(),
        private val blockSize: Int = 16
) : World {

    override fun putSprite(
            character: Sprite,
            coordinate: WorldCoordinate
    ) {
        sprites += character
        character.position().update(coordinate.toPosition(blockSize))
    }

    override fun sprites(): List<Sprite> {
        return ArrayList(sprites)
    }

    override fun tick() {
        sprites.forEach {
            checkCollisions(it)
            it.tick()
        }
    }

    private fun checkCollisions(currentSprite: Sprite) {
        sprites.filter { currentSprite != it }
                .filter { it !is ImmovableSprite }
                .forEach { currentSprite.checkCollision(it) }
    }
}
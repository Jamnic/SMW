package game.domain.block

import game.domain.sprite.Sprite
import game.unit.force.TemporaryMonoForce
import game.unit.Value

class SolidSprite(
        private val spriteDelegate: Sprite
) : Sprite by spriteDelegate {

    override fun checkCollision(sprite: Sprite) {
        if (sprite.rect().intersects(this.rect())) {
            sprite.collide(this)
        }
    }

    override fun collide(sprite: Sprite) {
        spriteDelegate.collide(sprite)

        if (sprite is SolidSprite) {
            val direction = this.rect().corner(sprite.rect())
            this.addForce(TemporaryMonoForce(Value.stop(), direction))
        }
    }
}   
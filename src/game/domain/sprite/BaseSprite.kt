package game.domain.sprite

import game.unit.Position
import game.unit.Rect
import game.unit.Size
import game.unit.force.Forces
import game.unit.force.MonoForce

class BaseSprite(
        size: Size
) : Sprite {

    private val forces: Forces = Forces()
    private val rect: Rect = Rect(size)

    override fun addForce(force: MonoForce) {
        forces.plusAssign(force)
    }

    override fun rect(): Rect {
        return this.rect
    }

    override fun checkCollision(sprite: Sprite) {
        if (this.rect.intersects(sprite.rect())) {
            sprite.collide(this)
        }
    }

    override fun collide(sprite: Sprite) {
        // to nothing
    }

    override fun tick() {
        rect.update(forces.calculateVelocity())
    }
}
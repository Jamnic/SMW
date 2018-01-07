package game.domain.sprite

import game.unit.*
import game.unit.force.Forces
import game.unit.force.MonoForce

class BaseSprite(
        size: Size,
        private val position: Position = Position(),
        private val velocity: Velocity = Velocity()
) : Sprite {

    private val forces: Forces = Forces()
    private val rect: Rect = Rect(position, size)

    override fun position(): Position {
        return position
    }

    override fun velocity(): Velocity {
        return this.velocity
    }

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
        forces.calculateVelocity(velocity)
        position.update(velocity)
    }
}
package game.domain.sprite

import game.time.Tickable
import game.unit.Rect
import game.unit.force.MonoForce

interface Sprite : Tickable {
    fun checkCollision(sprite: Sprite)
    fun collide(sprite: Sprite)
    fun rect(): Rect

    fun addForce(force: MonoForce)
}
package game.unit

import game.unit.value.UnspecifiedValue
import game.unit.value.Value

data class Velocity(
        val x: Value = UnspecifiedValue(),
        val y: Value = UnspecifiedValue()
) {

    operator fun plus(velocity: Velocity): Velocity {
        return Velocity(
                this.x + velocity.x,
                this.y + velocity.y)
    }

    override fun toString(): String {
        return "{$x $y}"
    }
}
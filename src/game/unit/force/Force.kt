package game.unit.force

import game.unit.Velocity
import game.unit.value.Value

class Force(
        val x: Value,
        val y: Value
) {

    override fun toString(): String {
        return "[$x, $y]"
    }

    fun toVelocity(): Velocity {
        return Velocity(x, y)
    }
}
package game.unit

import game.unit.force.Force
import game.unit.value.UnspecifiedValue
import game.unit.value.Value

class Velocity(
        private var x: Value = UnspecifiedValue(),
        private var y: Value = UnspecifiedValue()
) {

    fun x(): Value {
        return x
    }

    fun y(): Value {
        return y
    }

    fun update(force: Force) {
        this.x = force.x
        this.y = force.y
    }

    override fun toString(): String {
        return "{$x $y}"
    }
}
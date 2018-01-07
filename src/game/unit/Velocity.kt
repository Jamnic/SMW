package game.unit

import game.unit.force.Force

class Velocity(
        private var x: Value = Value.unspecified(),
        private var y: Value = Value.unspecified()
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
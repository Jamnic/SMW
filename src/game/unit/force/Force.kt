package game.unit.force

import game.unit.Value

class Force(
        val x: Value,
        val y: Value
) {

    override fun toString(): String {
        return "[$x, $y]"
    }
}
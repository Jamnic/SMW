package game.unit.force

import game.unit.Direction
import game.unit.Value

open class MonoForce(
        val value: Value,
        val direction: Direction
) {
    operator fun plus(monoForce: MonoForce): MonoForce {
        return monoForce
    }

    override fun toString(): String {
        return "$value in $direction"
    }
}
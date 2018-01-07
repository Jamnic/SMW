package game.unit.force

import game.unit.Direction
import game.unit.value.Value
import game.unit.Velocity
import game.unit.value.UnspecifiedValue

class Forces(
        private val forces: MutableList<MonoForce> = mutableListOf()
) {

    operator fun plusAssign(force: MonoForce) {
        this.forces += force
    }

    fun calculateVelocity(velocity: Velocity) {
        velocity.update(Force(sumForces(Direction.LEFT, Direction.RIGHT),
                sumForces(Direction.UP, Direction.DOWN)))

        forces.removeIf { it is TemporaryMonoForce }
    }

    private fun sumForces(first: Direction, second: Direction): Value {
        return sumForcesValue(second)
                .plusCounterValue(sumForcesValue(first))
    }

    private fun sumForcesValue(direction: Direction): Value {
        return forces
                .filter { it.direction == direction }
                .fold(UnspecifiedValue() as Value, { acc, value -> acc.plus(value.value) })
    }
}
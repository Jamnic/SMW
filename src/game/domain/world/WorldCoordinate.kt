package game.domain.world

import game.unit.Position

class WorldCoordinate(
        private val x: Int,
        private val y: Int
) {

    fun toPosition(size: Int): Position {
        return Position(size * x, size * y)
    }
}
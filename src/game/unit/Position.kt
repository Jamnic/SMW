package game.unit

class Position(
        private var x: Double = 0.0,
        private var y: Double = 0.0
) {

    constructor(
            x: Int,
            y: Int
    ) : this(
            x.toDouble(),
            y.toDouble())

    fun x(): Double {
        return x
    }

    fun y(): Double {
        return y
    }

    fun update(position: Position) {
        this.x = position.x
        this.y = position.y
    }

    fun update(velocity: Velocity) {
        this.x += velocity.x().evaluate()
        this.y += velocity.y().evaluate()
    }

    operator fun plus(position: Position): Position {
        return Position(
                this.x + position.x,
                this.y + position.y)
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}
package game.unit

data class Position(
        private var x: Double = 0.0,
        private var y: Double = 0.0
) {

    constructor(x: Double, y: Int) : this(x, y.toDouble())
    constructor(x: Int, y: Double) : this(x.toDouble(), y)
    constructor(x: Int, y: Int) : this(x.toDouble(), y.toDouble())

    fun x(): Double {
        return x
    }

    fun y(): Double {
        return y
    }

    operator fun plus(position: Position): Position {
        return Position(
                this.x + position.x,
                this.y + position.y)
    }

    operator fun plus(velocity: Velocity): Position {
        return Position(
                velocity.x + this.x,
                velocity.y + this.y)
    }

    override fun toString(): String {
        return "($x, $y)"
    }
}
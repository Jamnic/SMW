package game.unit

class Size(
        private val x: Double = 0.0,
        private val y: Double = 0.0
) {

    constructor(
            width: Int,
            height: Int
    ) : this(width.toDouble(), height.toDouble())

    fun x(): Double {
        return x
    }

    fun y(): Double {
        return y
    }

    override fun toString(): String {
        return "[$x $y]"
    }
}
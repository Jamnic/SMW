package game.unit.value

open class Value(
        var value: Double
) {

    constructor() : this(0.0)

    open operator fun plus(value: Value): Value {
        return when (value) {
            is UnspecifiedValue -> this
            is StopValue -> StopValue()
            else -> Value(this.value + value.value)
        }
    }

    open fun plusCounterValue(counterValue: Value): Value {
        return when {
            counterValue is StopValue -> this
            this is StopValue -> counterValue.negate()
            else -> counterValue.negate() + this
        }
    }

    open fun evaluate(): Double {
        return this.value
    }

    fun negate(): Value {
        return Value(-this.value)
    }

    override fun toString(): String {
        return "$value"
    }

    operator fun plus(value: Double): Double {
        return this.evaluate() + value
    }
}
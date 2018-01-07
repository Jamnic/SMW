package game.unit.value

class UnspecifiedValue : Value() {

    override operator fun plus(value: Value): Value {
        return when (value) {
            is UnspecifiedValue -> this
            is StopValue -> StopValue()
            else -> value
        }
    }

    override fun plusCounterValue(counterValue: Value): Value {
        return when (counterValue) {
            is StopValue -> this
            else -> counterValue.negate() + this
        }
    }

    override fun evaluate(): Double {
        return 0.0
    }

    override fun toString(): String {
        return "Unspecified"
    }
}
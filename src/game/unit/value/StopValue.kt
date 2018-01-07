package game.unit.value

class StopValue : Value() {

    override operator fun plus(value: Value): Value {
        return StopValue()
    }

    override fun plusCounterValue(counterValue: Value): Value {
        return when (counterValue) {
            is StopValue -> StopValue()
            else -> counterValue.negate()
        }
    }

    override fun evaluate(): Double {
        return 0.0
    }

    override fun toString(): String {
        return "Stop"
    }
}
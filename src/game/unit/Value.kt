package game.unit

import game.unit.Value.ValueType.*

class Value(
        private var valueType: ValueType,
        var value: Double) {

    companion object {
        fun of(value: Double): Value {
            return Value(SPECIFIED, value)
        }

        fun of(value: Double?): Value {
            return if (value == null)
                unspecified()
            else
                Value(SPECIFIED, value)
        }

        fun unspecified(): Value {
            return Value(UNSPECIFIED, 0.0)
        }

        fun stop(): Value {
            return Value(STOP, 0.0)
        }
    }

    operator fun plusAssign(value: Value) {
        when (value.valueType) {
            SPECIFIED -> {
                when (this.valueType) {
                    SPECIFIED -> this.value += value.value
                    UNSPECIFIED -> of(value.value)
                    STOP -> stop()
                }
            }
            UNSPECIFIED -> {
            }
            STOP -> stop()
        }
    }

    operator fun plus(value: Value): Value {
        return when (value.valueType) {
            SPECIFIED -> {
                when (this.valueType) {
                    SPECIFIED -> Value.of(this.value + value.value)
                    UNSPECIFIED -> value
                    STOP -> Value.stop()
                }
            }
            UNSPECIFIED -> this
            STOP -> Value.stop()
        }
    }

    fun evaluate(): Double {
        return when (this.valueType) {
            SPECIFIED -> this.value
            UNSPECIFIED, STOP -> 0.0
        }
    }

    fun plusCounterValue(counterValue: Value): Value {
        return when {
            counterValue.isStop() -> this
            this.isStop() -> counterValue.negate()
            else -> counterValue.negate() + this
        }
    }

    private fun of(value: Double) {
        this.value = value
        this.valueType = SPECIFIED
    }

    private fun stop() {
        this.value = 0.0
        this.valueType = STOP
    }

    private fun isStop(): Boolean {
        return valueType == STOP
    }

    private fun negate(): Value {
        return Value(this.valueType, -this.value)
    }

    override fun toString(): String {
        return when (this.valueType) {
            SPECIFIED -> "$value"
            UNSPECIFIED -> "Unspecified"
            STOP -> "Stop"
        }
    }

    enum class ValueType {
        SPECIFIED,
        UNSPECIFIED,
        STOP
    }
}
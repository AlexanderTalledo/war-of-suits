package alexta.interviews.wallapop.shared.domain.valueobjects

import alexta.interviews.wallapop.shared.domain.errors.InvalidValue
import java.util.*

abstract class StringValueObject(val value: String) {

    @Throws(InvalidValue::class)
    abstract fun validate()

    override fun equals(other: Any?): Boolean {
        if (null == other) return false
        if (javaClass != other.javaClass) return false
        if (this === other) return true
        return value == (other as StringValueObject).value
    }

    override fun hashCode() = Objects.hash(value)

    override fun toString() = value

}
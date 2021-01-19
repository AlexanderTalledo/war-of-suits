package alexta.interviews.wallapop.shared.domain.valueobjects

import alexta.interviews.wallapop.shared.domain.errors.InvalidValue
import alexta.interviews.wallapop.shared.domain.utils.IdentifierUtils

abstract class Identifier(value: String) : StringValueObject(value) {

    override fun validate() {
        if (!isValidValue()) throw InvalidValue(value)
    }

    private fun isValidValue() = IdentifierUtils.isValid(value)

}
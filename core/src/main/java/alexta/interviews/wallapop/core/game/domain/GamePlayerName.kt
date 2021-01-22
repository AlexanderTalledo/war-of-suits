package alexta.interviews.wallapop.core.game.domain

import alexta.interviews.wallapop.shared.domain.errors.InvalidValue
import alexta.interviews.wallapop.shared.domain.valueobjects.StringValueObject

class GamePlayerName(value: String) : StringValueObject(value) {

    init {
        validate()
    }

    override fun validate() {
        if (!isValidValue()) throw InvalidValue(value)
    }

    private fun isValidValue() = value.isNotEmpty()

}
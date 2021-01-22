package alexta.interviews.wallapop.core.game.domain

import alexta.interviews.wallapop.shared.domain.errors.InvalidValue
import alexta.interviews.wallapop.shared.domain.valueobjects.IntegerValueObject

class GamePlayerScore(value: Int) : IntegerValueObject(value) {

    init {
        validate()
    }

    override fun validate() {
        if (!isValidValue()) throw InvalidValue(value.toString())
    }

    private fun isValidValue() = value >= 0

}

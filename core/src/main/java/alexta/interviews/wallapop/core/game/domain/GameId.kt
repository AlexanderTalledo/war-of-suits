package alexta.interviews.wallapop.core.game.domain

import alexta.interviews.wallapop.shared.domain.valueobjects.Identifier

class GameId internal constructor(value: String) : Identifier(value) {

    init {
        validate()
    }

}
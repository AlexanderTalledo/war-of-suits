package alexta.interviews.wallapop.core.game.domain

import alexta.interviews.wallapop.shared.domain.valueobjects.IdentifierMother

object GameIdMother {

    fun create(id: String = IdentifierMother.random()) = GameId(id)

}
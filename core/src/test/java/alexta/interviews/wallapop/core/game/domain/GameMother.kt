package alexta.interviews.wallapop.core.game.domain

import alexta.interviews.wallapop.shared.domain.valueobjects.IdentifierMother

object GameMother {

    fun create(
        id: String = IdentifierMother.random()
    ) = Game(
        GameId(id)
    )

}
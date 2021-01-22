package alexta.interviews.wallapop.core.game.domain

import alexta.interviews.wallapop.shared.domain.valueobjects.NameMother

object GamePlayerNameMother {

    fun create(name: String = NameMother.random()) = GamePlayerName(name)

}
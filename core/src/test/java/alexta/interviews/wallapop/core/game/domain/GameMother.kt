package alexta.interviews.wallapop.core.game.domain

object GameMother {

    fun create(
        id: String = GameIdMother.create().value
    ) = Game(
        GameId(id)
    )

}
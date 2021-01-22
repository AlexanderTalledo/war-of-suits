package alexta.interviews.wallapop.core.game.domain

object GamePlayerMother {

    fun create(
        name: String = GamePlayerNameMother.create().value,
        type: GamePlayerType
    ) = GamePlayer(GamePlayerName(name), type)

}
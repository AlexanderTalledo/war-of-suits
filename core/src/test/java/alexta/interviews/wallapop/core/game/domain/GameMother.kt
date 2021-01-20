package alexta.interviews.wallapop.core.game.domain

object GameMother {

    fun create(
        id: String = GameIdMother.create().value,
        deck: GameDeck = GameDeckMother.create(),
        criteria: GameRoundCriteria = GameRoundCriteriaMother.create(),
        playerOne: GamePlayer = GamePlayerMother.create(type = GamePlayerType.PLAYER_ONE),
        playerTwo: GamePlayer = GamePlayerMother.create(type = GamePlayerType.PLAYER_TWO)
    ) = Game(GameId(id), deck, criteria, playerOne, playerTwo)

}
package alexta.interviews.wallapop.core.game.domain

object GameCardMother {

    fun create(suit: GameCardSuit, rank: GameCardRank) = GameCard(suit, rank)

}
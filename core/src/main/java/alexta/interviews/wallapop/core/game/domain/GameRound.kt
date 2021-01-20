package alexta.interviews.wallapop.core.game.domain

data class GameRound(
    val playerOneRound: Pair<GamePlayer, GameCard>,
    val playerTwoRound: Pair<GamePlayer, GameCard>,
    val winner: GamePlayerType,
    val priorities: List<GameCardSuit>
)

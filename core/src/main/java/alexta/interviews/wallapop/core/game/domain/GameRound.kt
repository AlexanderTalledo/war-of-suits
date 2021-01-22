package alexta.interviews.wallapop.core.game.domain

data class GameRound(
    val playerOneGamePlay: GamePlay,
    val playerTwoGamePlay: GamePlay,
    val winner: GamePlayerType,
    val priorities: List<GameCardSuit>
)

package alexta.interviews.wallapop.core.game.domain

data class GameSummary(
    val playerOne: GamePlayer,
    val playerTwo: GamePlayer,
    val rounds: List<GameRound>
)
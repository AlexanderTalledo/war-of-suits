package alexta.interviews.wallapop.core.game.domain

data class GamePlay(
    val name: GamePlayerName,
    val type: GamePlayerType,
    val score: GamePlayerScore,
    val card: GameCard
)
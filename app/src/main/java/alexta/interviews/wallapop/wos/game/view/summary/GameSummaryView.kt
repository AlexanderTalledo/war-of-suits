package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.core.game.domain.GameRound
import alexta.interviews.wallapop.core.game.domain.GameSummary

data class GameSummaryView(
    internal val winner: GameSummaryWinnerView,
    internal val items: List<GameSummaryItemView>
)

internal fun GameSummary.toGameSummaryView(): GameSummaryView {
    val winner = GameSummaryWinnerView(playerOne, playerTwo)
    val items = mutableListOf<GameSummaryItemView>()
    for (round in this.rounds) {
        items.add(round.toGameSummaryItemView())
    }
    return GameSummaryView(winner, items)
}

private fun GameRound.toGameSummaryItemView() = GameSummaryItemView(
    GameSummaryItemPlayerView(this.playerOneGamePlay),
    GameSummaryItemPlayerView(this.playerTwoGamePlay),
    winner
)

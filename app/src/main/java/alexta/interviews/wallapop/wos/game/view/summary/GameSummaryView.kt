package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.core.game.domain.GameRound
import alexta.interviews.wallapop.core.game.domain.GameSummary

data class GameSummaryView(internal val items: List<GameSummaryItemView>)

internal fun GameSummary.toGameSummaryView(): GameSummaryView {
    val items = mutableListOf<GameSummaryItemView>()
    for (round in this.rounds) {
        items.add(round.toGameSummaryItemView())
    }
    return GameSummaryView(items)
}

private fun GameRound.toGameSummaryItemView() = GameSummaryItemView(
    GameSummaryItemPlayerView(this.playerOneRound.first, this.playerOneRound.second),
    GameSummaryItemPlayerView(this.playerTwoRound.first, this.playerTwoRound.second),
    winner
)

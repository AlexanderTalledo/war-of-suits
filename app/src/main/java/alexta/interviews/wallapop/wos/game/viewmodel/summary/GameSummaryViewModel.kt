package alexta.interviews.wallapop.wos.game.viewmodel.summary

import alexta.interviews.wallapop.core.game.application.find.GameFinder
import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameSummary
import alexta.interviews.wallapop.wos.shared.framework.lifecycle.OperationViewModel
import javax.inject.Inject

class GameSummaryViewModel @Inject constructor(
    private val finder: GameFinder
) : OperationViewModel<GameSummaryOperation>() {

    internal fun gameSummary(gameId: String) {
        currentGame(gameId)?.run { onGameSummary(this.summary()) }
    }

    private fun currentGame(gameId: String): Game? = finder.find(gameId)

    private fun onGameSummary(summary: GameSummary) {
        update(GameSummaryOperation.OnGameSummary(summary))
    }

}
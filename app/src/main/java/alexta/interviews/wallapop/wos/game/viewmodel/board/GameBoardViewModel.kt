package alexta.interviews.wallapop.wos.game.viewmodel.board

import alexta.interviews.wallapop.core.game.application.find.GameFinder
import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameRound
import alexta.interviews.wallapop.wos.shared.framework.lifecycle.OperationViewModel
import javax.inject.Inject

class GameBoardViewModel @Inject constructor(
    private val finder: GameFinder
) : OperationViewModel<GameBoardOperation>() {

    internal fun startGame(gameId: String) {
        val game = currentGame(gameId)
        game?.run {
            this.start()
            val round = this.nextRound()
            onGameStarted(round!!)
        }
    }

    private fun currentGame(gameId: String): Game? = finder.find(gameId)

    private fun onGameStarted(round: GameRound) = update(GameBoardOperation.OnGameStarted(round))

}
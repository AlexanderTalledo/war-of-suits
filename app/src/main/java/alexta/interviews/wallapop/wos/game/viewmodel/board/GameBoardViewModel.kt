package alexta.interviews.wallapop.wos.game.viewmodel.board

import alexta.interviews.wallapop.core.game.application.find.GameFinder
import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameRound
import alexta.interviews.wallapop.wos.shared.framework.lifecycle.OperationViewModel
import javax.inject.Inject

class GameBoardViewModel @Inject constructor(
    private val finder: GameFinder
) : OperationViewModel<GameBoardOperation>() {

    private var game: Game? = null

    internal fun startGame(gameId: String) {
        game = currentGame(gameId)
        game?.run {
            this.start()
            val round = this.nextRound()
            onGameStarted(round!!)
        }
    }

    private fun currentGame(gameId: String): Game? = finder.find(gameId)

    private fun onGameStarted(round: GameRound) = update(GameBoardOperation.OnGameStarted(round))

    internal fun resetGame() {
        game?.run {
            this.restart()
            val round = this.nextRound()
            onGameReset(round!!)
        }
    }

    private fun onGameReset(round: GameRound) = update(GameBoardOperation.OnGameReset(round))

    internal fun playNextRound() {
        game?.run {
            val round = this.nextRound()
            if (round == null) onGameEnded()
            else onGameRoundPlayed(round)
        }
    }

    private fun onGameRoundPlayed(round: GameRound) {
        update(GameBoardOperation.OnGameRoundPlayed(round))
    }

    private fun onGameEnded() {
        TODO("Not yet implemented")
    }

}
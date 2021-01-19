package alexta.interviews.wallapop.wos.game.splash.viewmodel

import alexta.interviews.wallapop.core.game.application.create.GameCreator
import alexta.interviews.wallapop.wos.shared.framework.lifecycle.OperationViewModel
import javax.inject.Inject

class GameSplashViewModel @Inject constructor(
    private val creator: GameCreator
) : OperationViewModel<GameSplashOperation>() {

    internal fun createNewGame() {
        val gameId = generateGameId()
        createGame(gameId)
        onNewGameCreated(gameId)
    }

    private fun generateGameId() = ""

    private fun createGame(id: String) = creator(id)

    private fun onNewGameCreated(id: String) = update(GameSplashOperation.OnGameCreated(id))

}
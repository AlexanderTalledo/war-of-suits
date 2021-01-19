package alexta.interviews.wallapop.wos.game.viewmodel.splash

import alexta.interviews.wallapop.core.game.application.create.GameCreator
import alexta.interviews.wallapop.shared.domain.utils.IdentifierUtils
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

    private fun generateGameId() = IdentifierUtils.generate()

    private fun createGame(id: String) = creator.create(id)

    private fun onNewGameCreated(id: String) {
        update(GameSplashOperation.OnGameCreated(id))
    }

}
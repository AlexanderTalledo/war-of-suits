package alexta.interviews.wallapop.wos.game.viewmodel.board

import alexta.interviews.wallapop.core.game.domain.GameRound
import alexta.interviews.wallapop.wos.shared.framework.lifecycle.ViewModelOperation

sealed class GameBoardOperation : ViewModelOperation {

    class OnGameStarted(val round: GameRound) : GameBoardOperation()

}
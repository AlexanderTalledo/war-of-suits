package alexta.interviews.wallapop.wos.game.viewmodel.board

import alexta.interviews.wallapop.wos.shared.framework.lifecycle.ViewModelOperation

sealed class GameBoardOperation : ViewModelOperation {

    object OnGameStarted : GameBoardOperation()

}

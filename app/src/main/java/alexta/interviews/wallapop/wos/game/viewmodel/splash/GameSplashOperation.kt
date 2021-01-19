package alexta.interviews.wallapop.wos.game.viewmodel.splash

import alexta.interviews.wallapop.wos.shared.framework.lifecycle.ViewModelOperation

sealed class GameSplashOperation : ViewModelOperation {

    class OnGameCreated(val gameId: String) : GameSplashOperation()

}

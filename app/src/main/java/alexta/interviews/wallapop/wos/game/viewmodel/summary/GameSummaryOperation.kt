package alexta.interviews.wallapop.wos.game.viewmodel.summary

import alexta.interviews.wallapop.core.game.domain.GameSummary
import alexta.interviews.wallapop.wos.shared.framework.lifecycle.ViewModelOperation

sealed class GameSummaryOperation : ViewModelOperation {

    class OnGameSummary(val summary: GameSummary) : GameSummaryOperation()

}

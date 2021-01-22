package alexta.interviews.wallapop.wos.game.view.board

import alexta.interviews.wallapop.core.game.domain.GameRound

data class GameBoardView(
    internal val playerOneView: GameBoardPlayerView,
    internal val playerTwoView: GameBoardPlayerView,
    internal val prioritiesView: GameBoardPriorityView
)

internal fun GameRound.toGameBoardView() = GameBoardView(
    GameBoardPlayerView(this.playerOneGamePlay, this.winner),
    GameBoardPlayerView(this.playerTwoGamePlay, this.winner),
    GameBoardPriorityView(this.priorities)
)
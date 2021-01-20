package alexta.interviews.wallapop.wos.game.view.board

import alexta.interviews.wallapop.core.game.domain.GameRound

data class GameBoardView(
    internal val playerOneView: GameBoardPlayerView,
    internal val playerTwoView: GameBoardPlayerView,
)

internal fun GameRound.toGameBoardView() = GameBoardView(
    GameBoardPlayerView(this.playerOneRound.first, this.playerOneRound.second, this.winner),
    GameBoardPlayerView(this.playerTwoRound.first, this.playerTwoRound.second, this.winner)
)
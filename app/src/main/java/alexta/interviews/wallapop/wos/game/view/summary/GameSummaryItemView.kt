package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.core.game.domain.GamePlayerType
import alexta.interviews.wallapop.wos.R
import androidx.annotation.ColorRes

class GameSummaryItemView(
    internal val playerOneItemView: GameSummaryItemPlayerView,
    internal val playerTwoItemView: GameSummaryItemPlayerView,
    private val winner: GamePlayerType
) {

    @ColorRes
    internal val backgroundColor = rowBackgroundColor()

    private fun rowBackgroundColor() = when (winner) {
        GamePlayerType.PLAYER_ONE -> R.color.suit_red
        GamePlayerType.PLAYER_TWO -> R.color.suit_black
    }

}

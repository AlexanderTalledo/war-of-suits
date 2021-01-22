package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.core.game.domain.GamePlayer
import alexta.interviews.wallapop.wos.R
import android.content.Context

class GameSummaryWinnerView(
    private val playerOne: GamePlayer,
    private val playerTwo: GamePlayer
) {

    internal fun name(context: Context) = when {
        playerOne.discardCount > playerTwo.discardCount -> playerOne.name.value
        playerTwo.discardCount > playerOne.discardCount -> playerTwo.name.value
        else -> context.resources.getString(R.string.game_summary_winner_name_tie)
    }

}
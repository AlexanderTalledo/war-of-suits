package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.wos.R
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameSummaryViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    internal fun bind(item: GameSummaryItemView) {
        setGameSummaryItemView(item)
    }

    private fun setGameSummaryItemView(item: GameSummaryItemView) = with(item) {
        view.findViewById<LinearLayout>(R.id.gameSummaryItemContainer)
            .setBackgroundResource(backgroundColor)
        setGameSummaryItemPlayerOneView(playerOneItemView)
        setGameSummaryItemPlayerTwoView(playerTwoItemView)
    }

    private fun setGameSummaryItemPlayerOneView(playerOneItemView: GameSummaryItemPlayerView) {
        with(playerOneItemView) {
            view.findViewById<TextView>(R.id.gameSummaryItemPlayerOneCardRank).setText(cardRank)
            view.findViewById<ImageView>(R.id.gameSummaryItemPlayerOneCardSuit)
                .setImageResource(cardSuit)
            view.findViewById<TextView>(R.id.gameSummaryItemPlayerOneName).text = name
            view.findViewById<TextView>(R.id.gameSummaryItemPlayerOneScore).text = score
        }
    }

    private fun setGameSummaryItemPlayerTwoView(playerTwoItemView: GameSummaryItemPlayerView) {
        with(playerTwoItemView) {
            view.findViewById<TextView>(R.id.gameSummaryItemPlayerTwoCardRank).setText(cardRank)
            view.findViewById<ImageView>(R.id.gameSummaryItemPlayerTwoCardSuit)
                .setImageResource(cardSuit)
            view.findViewById<TextView>(R.id.gameSummaryItemPlayerTwoName).text = name
            view.findViewById<TextView>(R.id.gameSummaryItemPlayerTwoScore).text = score
        }
    }

}
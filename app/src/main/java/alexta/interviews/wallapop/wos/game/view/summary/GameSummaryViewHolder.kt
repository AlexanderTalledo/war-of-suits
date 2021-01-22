package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.wos.databinding.ItemGameSummaryBinding
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GameSummaryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val viewBinding = ItemGameSummaryBinding.bind(view)

    internal fun bind(item: GameSummaryItemView) {
        setGameSummaryItemView(item)
    }

    private fun setGameSummaryItemView(item: GameSummaryItemView) = with(item) {
        viewBinding.gameSummaryItemContainer.setBackgroundResource(backgroundColor)
        setGameSummaryItemPlayerOneView(playerOneItemView)
        setGameSummaryItemPlayerTwoView(playerTwoItemView)
    }

    private fun setGameSummaryItemPlayerOneView(playerOneItemView: GameSummaryItemPlayerView) {
        with(playerOneItemView) {
            with(viewBinding) {
                gameSummaryItemPlayerOneCardRank.setText(cardRank)
                gameSummaryItemPlayerOneCardSuit.setImageResource(cardSuit)
                gameSummaryItemPlayerOneName.text = name
                gameSummaryItemPlayerOneScore.text = score
            }
        }
    }

    private fun setGameSummaryItemPlayerTwoView(playerTwoItemView: GameSummaryItemPlayerView) {
        with(playerTwoItemView) {
            with(viewBinding) {
                gameSummaryItemPlayerTwoCardRank.setText(cardRank)
                gameSummaryItemPlayerTwoCardSuit.setImageResource(cardSuit)
                gameSummaryItemPlayerTwoName.text = name
                gameSummaryItemPlayerTwoScore.text = score
            }
        }
    }

}
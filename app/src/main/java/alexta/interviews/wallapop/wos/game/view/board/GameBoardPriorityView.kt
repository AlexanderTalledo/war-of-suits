package alexta.interviews.wallapop.wos.game.view.board

import alexta.interviews.wallapop.core.game.domain.GameCardSuit
import alexta.interviews.wallapop.wos.R
import androidx.annotation.DrawableRes

class GameBoardPriorityView(private val suitPriorities: List<GameCardSuit>) {

    internal val roundPriorities = roundPrioritiesList()

    private fun roundPrioritiesList(): List<Int> {
        val priorities = mutableListOf<@DrawableRes Int>()
        for (suit in suitPriorities) {
            when (suit) {
                GameCardSuit.CLUBS -> priorities.add(R.drawable.ic_suit_clubs)
                GameCardSuit.DIAMONDS -> priorities.add(R.drawable.ic_suit_diamonds)
                GameCardSuit.HEARTS -> priorities.add(R.drawable.ic_suit_hearts)
                GameCardSuit.SPADES -> priorities.add(R.drawable.ic_suit_spades)
            }
        }
        return priorities
    }

}

package alexta.interviews.wallapop.wos.game.view.summary

import alexta.interviews.wallapop.core.game.domain.GameCardRank
import alexta.interviews.wallapop.core.game.domain.GameCardSuit
import alexta.interviews.wallapop.core.game.domain.GamePlay
import alexta.interviews.wallapop.wos.R
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class GameSummaryItemPlayerView(private val gamePlay: GamePlay) {

    @StringRes
    internal val cardRank = cardRankText()

    @DrawableRes
    internal val cardSuit = cardSuitImage()

    internal val name = playerName()

    internal val score = playerScore()

    private fun cardRankText() = when (gamePlay.card.rank) {
        GameCardRank.TWO -> R.string.game_board_card_rank_two
        GameCardRank.THREE -> R.string.game_board_card_rank_three
        GameCardRank.FOUR -> R.string.game_board_card_rank_four
        GameCardRank.FIVE -> R.string.game_board_card_rank_five
        GameCardRank.SIX -> R.string.game_board_card_rank_six
        GameCardRank.SEVEN -> R.string.game_board_card_rank_seven
        GameCardRank.EIGHT -> R.string.game_board_card_rank_eight
        GameCardRank.NINE -> R.string.game_board_card_rank_nine
        GameCardRank.TEN -> R.string.game_board_card_rank_ten
        GameCardRank.JACK -> R.string.game_board_card_rank_jack
        GameCardRank.QUEEN -> R.string.game_board_card_rank_queen
        GameCardRank.KING -> R.string.game_board_card_rank_king
        GameCardRank.ACE -> R.string.game_board_card_rank_ace
    }

    private fun cardSuitImage() = when (gamePlay.card.suit) {
        GameCardSuit.CLUBS -> R.drawable.ic_suit_clubs
        GameCardSuit.DIAMONDS -> R.drawable.ic_suit_diamonds
        GameCardSuit.HEARTS -> R.drawable.ic_suit_hearts
        GameCardSuit.SPADES -> R.drawable.ic_suit_spades
    }

    private fun playerName() = gamePlay.name.value

    private fun playerScore() = gamePlay.score.value.toString()

}
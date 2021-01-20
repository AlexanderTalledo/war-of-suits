package alexta.interviews.wallapop.wos.game.view.board

import alexta.interviews.wallapop.core.game.domain.*
import alexta.interviews.wallapop.wos.R
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class GameBoardPlayerView(
    private val player: GamePlayer,
    private val card: GameCard,
    private val winner: GamePlayerType
) {
    @StringRes
    internal val roundWinner = roundWinnerText()

    @StringRes
    internal val cardRank = cardRankText()

    @DrawableRes
    internal val cardSuit = cardSuitImage()

    internal val score = scoreText()

    private fun roundWinnerText(): Int {
        return if (player.type == winner) R.string.game_board_round_winner
        else R.string.game_board_round_loser
    }

    private fun cardRankText() = when (card.rank) {
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

    private fun cardSuitImage() = when (card.suit) {
        GameCardSuit.CLUBS -> R.drawable.ic_suit_clubs
        GameCardSuit.DIAMONDS -> R.drawable.ic_suit_diamonds
        GameCardSuit.HEARTS -> R.drawable.ic_suit_hearts
        GameCardSuit.SPADES -> R.drawable.ic_suit_spades
    }

    private fun scoreText() = "${player.name}'s score: ${player.discardCount}"

}
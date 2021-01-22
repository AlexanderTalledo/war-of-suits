package alexta.interviews.wallapop.core.game.domain

class GameRoundCriteria {

    internal val suitPriorities: List<GameCardSuit>
        get() = _suitPriorities

    private val _suitPriorities = mutableListOf(
        GameCardSuit.CLUBS,
        GameCardSuit.DIAMONDS,
        GameCardSuit.HEARTS,
        GameCardSuit.SPADES
    )

    internal fun shuffle() = _suitPriorities.shuffle()

    internal fun roundWinner(cards: Pair<GameCard, GameCard>) = with(cards) {
        when {
            first.rank.value < second.rank.value -> GamePlayerType.PLAYER_TWO
            first.rank.value > second.rank.value -> GamePlayerType.PLAYER_ONE
            else -> roundWinnerByPriority(this)
        }
    }

    private fun roundWinnerByPriority(cards: Pair<GameCard, GameCard>) = with(cards) {
        for (priority in _suitPriorities) {
            if (first.suit == priority) return GamePlayerType.PLAYER_ONE
            if (second.suit == priority) return GamePlayerType.PLAYER_TWO
        }
        GamePlayerType.PLAYER_ONE
    }

}

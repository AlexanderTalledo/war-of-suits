package alexta.interviews.wallapop.core.game.domain

class GameRules {

    internal fun roundWinner(cards: Pair<GameCard, GameCard>) = with(cards) {
        when {
            first.rank.value < second.rank.value -> GamePlayerType.PLAYER_TWO
            first.rank.value > second.rank.value -> GamePlayerType.PLAYER_ONE
            else -> GamePlayerType.PLAYER_TWO
        }
    }

}

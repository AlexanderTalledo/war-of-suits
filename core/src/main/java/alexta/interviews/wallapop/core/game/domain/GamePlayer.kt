package alexta.interviews.wallapop.core.game.domain

import java.util.*

class GamePlayer(val name: GamePlayerName, val type: GamePlayerType) {

    val cardCount: Int
        get() = cardPile.size
    val discardCount: Int
        get() = discardPile.size

    private var cardPile = Stack<GameCard>()
    private var discardPile = Stack<GameCard>()

    internal fun setup(pile: Stack<GameCard>) {
        cardPile = pile
        discardPile.clear()
    }

    internal fun play() = if (cardPile.isNotEmpty()) cardPile.pop() else null

    internal fun discard(cards: Pair<GameCard, GameCard>): Unit = with(cards) {
        discardPile.push(first)
        discardPile.push(second)
    }

}
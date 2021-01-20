package alexta.interviews.wallapop.core.game.domain

import java.util.*

class Game(
    val id: GameId,
    private val deck: GameDeck,
    private val rules: GameRules,
    private val playerOne: GamePlayer,
    private val playerTwo: GamePlayer
) {

    fun start() {
        shuffleCards()
        dealCards()
    }

    fun restart() {
        dealCards()
    }

    private fun shuffleCards() = deck.shuffle()

    private fun dealCards() = with(splitDeck()) {
        playerOne.setup(first)
        playerTwo.setup(second)
    }

    private fun splitDeck() = with(deck) {
        val pileOne = Stack<GameCard>()
        val pileTwo = Stack<GameCard>()
        for (i in cards.indices) {
            val currentCard = cards[i]
            if (i.rem(2) == 0) pileOne.push(currentCard)
            else pileTwo.push(currentCard)
        }
        Pair(pileOne, pileTwo)
    }

    fun nextRound(): GameRound? {
        val cards = nextRoundCards() ?: return null
        val winner = rules.roundWinner(cards)
        updateRoundScore(winner, cards)
        return createRound(winner, cards)
    }

    private fun nextRoundCards(): Pair<GameCard, GameCard>? {
        val cardOne = playerOne.play()
        val cardTwo = playerTwo.play()
        return if (cardOne == null || cardTwo == null) null
        else Pair(cardOne, cardTwo)
    }

    private fun updateRoundScore(winner: GamePlayerType, cards: Pair<GameCard, GameCard>) {
        when (winner) {
            GamePlayerType.PLAYER_ONE -> playerOne.discard(cards)
            GamePlayerType.PLAYER_TWO -> playerTwo.discard(cards)
        }
    }

    private fun createRound(winner: GamePlayerType, cards: Pair<GameCard, GameCard>) = GameRound(
        Pair(playerOne, cards.first),
        Pair(playerTwo, cards.second),
        winner
    )

    override fun equals(other: Any?): Boolean {
        if (null == other) return false
        if (this.javaClass != other.javaClass) return false
        if (this === other) return true
        return with(other as Game) { id == this.id }
    }

    override fun hashCode() = Objects.hash(id)

}
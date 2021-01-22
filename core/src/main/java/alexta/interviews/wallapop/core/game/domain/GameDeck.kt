package alexta.interviews.wallapop.core.game.domain

class GameDeck {

    val cards: List<GameCard>
        get() = _cards

    private val _cards = initCards()

    private fun initCards(): MutableList<GameCard> {
        val cards = mutableListOf<GameCard>()
        for (suit in GameCardSuit.values()) {
            for (rank in GameCardRank.values()) {
                cards.add(GameCard(suit, rank))
            }
        }
        return cards
    }

    internal fun shuffle() = _cards.shuffle()

}
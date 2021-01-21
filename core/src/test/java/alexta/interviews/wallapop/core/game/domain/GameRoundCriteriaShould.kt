package alexta.interviews.wallapop.core.game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameRoundCriteriaShould {

    private val criteria = GameRoundCriteria()

    @Test
    fun `contain suit priorities`() {
        assertThat(criteria.suitPriorities.size).isEqualTo(4)
    }

    @Test
    fun `return player one as winner when player one's card value is higher`() {
        val cardOne = GameCardMother.create(GameCardSuit.HEARTS, GameCardRank.ACE)
        val cardTwo = GameCardMother.create(GameCardSuit.HEARTS, GameCardRank.KING)
        val cards = Pair(cardOne, cardTwo)

        val winner = criteria.roundWinner(cards)

        assertThat(winner).isEqualTo(GamePlayerType.PLAYER_ONE)
    }

    @Test
    fun `return player two as winner when player two's card value is higher`() {
        val cardOne = GameCardMother.create(GameCardSuit.SPADES, GameCardRank.FIVE)
        val cardTwo = GameCardMother.create(GameCardSuit.DIAMONDS, GameCardRank.JACK)
        val cards = Pair(cardOne, cardTwo)

        val winner = criteria.roundWinner(cards)

        assertThat(winner).isEqualTo(GamePlayerType.PLAYER_TWO)
    }


    @Test
    fun `return player one as winner when both cards have same value but better priority`() {
        val cardOne = GameCardMother.create(GameCardSuit.HEARTS, GameCardRank.ACE)
        val cardTwo = GameCardMother.create(GameCardSuit.SPADES, GameCardRank.ACE)
        val cards = Pair(cardOne, cardTwo)

        val winner = criteria.roundWinner(cards)

        assertThat(winner).isEqualTo(GamePlayerType.PLAYER_ONE)
    }


    @Test
    fun `return player two as winner when both cards have same value but better priority`() {
        val cardOne = GameCardMother.create(GameCardSuit.SPADES, GameCardRank.QUEEN)
        val cardTwo = GameCardMother.create(GameCardSuit.CLUBS, GameCardRank.QUEEN)
        val cards = Pair(cardOne, cardTwo)

        val winner = criteria.roundWinner(cards)

        assertThat(winner).isEqualTo(GamePlayerType.PLAYER_TWO)
    }

}
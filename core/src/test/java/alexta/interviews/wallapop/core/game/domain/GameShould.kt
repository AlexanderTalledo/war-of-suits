package alexta.interviews.wallapop.core.game.domain

import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*

class GameShould {

    private val id = mockk<GameId>(relaxUnitFun = true)
    private val deck = mockk<GameDeck>(relaxUnitFun = true)
    private val criteria = mockk<GameRoundCriteria>(relaxUnitFun = true)
    private val playerOne = mockk<GamePlayer>(relaxUnitFun = true)
    private val playerTwo = mockk<GamePlayer>(relaxUnitFun = true)
    private val game = Game(id, deck, criteria, playerOne, playerTwo)

    @BeforeEach
    fun setUp() {
        clearMocks(id, deck, criteria, playerOne, playerTwo)
    }

    @Nested
    internal inner class Start {

        @Test
        fun `shuffle deck once when game starts`() {
            every { deck.cards } returns listOf()

            game.start()

            verify(exactly = 1) { deck.shuffle() }
        }

        @Test
        fun `shuffle suit priorities once when game starts`() {
            every { deck.cards } returns listOf()

            game.start()

            verify(exactly = 1) { criteria.shuffle() }
        }

        @Test
        fun `deal a pile of cards to player one`() {
            val card = GameCardMother.create(GameCardSuit.SPADES, GameCardRank.EIGHT)
            val pile = slot<Stack<GameCard>>()
            every { deck.cards } returns listOf(card, card, card, card)
            every { playerOne.setup(capture(pile)) } answers { pile.captured }

            game.start()

            assertThat(pile.captured.size).isEqualTo(2)
        }

        @Test
        fun `deal a pile of cards to player two`() {
            val card = GameCardMother.create(GameCardSuit.HEARTS, GameCardRank.ACE)
            val pile = slot<Stack<GameCard>>()
            every { deck.cards } returns listOf(card, card)
            every { playerTwo.setup(capture(pile)) } answers { pile.captured }

            game.start()

            assertThat(pile.captured.size).isEqualTo(1)
        }
    }

    @Nested
    internal inner class Restart {

        @Test
        fun `not shuffle deck when game is restarted`() {
            every { deck.cards } returns listOf()

            game.restart()

            verify(exactly = 0) { deck.shuffle() }
        }

        @Test
        fun `not shuffle suit priorities when game is restarted`() {
            every { deck.cards } returns listOf()

            game.restart()

            verify(exactly = 0) { criteria.shuffle() }
        }

        @Test
        fun `deal a pile of cards to player one`() {
            val card = GameCardMother.create(GameCardSuit.HEARTS, GameCardRank.FIVE)
            val pile = slot<Stack<GameCard>>()
            every { deck.cards } returns listOf(card, card, card, card)
            every { playerOne.setup(capture(pile)) } answers { pile.captured }

            game.restart()

            assertThat(pile.captured.size).isEqualTo(2)
        }

        @Test
        fun `deal a pile of cards to player two`() {
            val card = GameCardMother.create(GameCardSuit.CLUBS, GameCardRank.JACK)
            val pile = slot<Stack<GameCard>>()
            every { deck.cards } returns listOf(card, card)
            every { playerTwo.setup(capture(pile)) } answers { pile.captured }

            game.restart()

            assertThat(pile.captured.size).isEqualTo(1)
        }

    }


    @Nested
    internal inner class Next {

        @Test
        fun `return null played round result when players have no more cards to play`() {
            every { playerOne.play() } returns null
            every { playerTwo.play() } returns null

            val round = game.nextRound()

            assertThat(round).isNull()
        }

        @Test
        fun `return a not null played round result when players still have cards to play`() {
            val card = GameCardMother.create(GameCardSuit.CLUBS, GameCardRank.JACK)
            every { playerOne.play() } returns card
            every { playerTwo.play() } returns card
            every { criteria.roundWinner(any()) } returns GamePlayerType.PLAYER_ONE
            every { criteria.suitPriorities } returns listOf()

            val round = game.nextRound()

            assertThat(round).isNotNull
        }

        @Test
        fun `increment player one's discard pile when player one wins the round`() {
            val card = GameCardMother.create(GameCardSuit.DIAMONDS, GameCardRank.TWO)
            val discardPair = slot<Pair<GameCard, GameCard>>()
            every { playerOne.play() } returns card
            every { playerTwo.play() } returns card
            every { criteria.roundWinner(any()) } returns GamePlayerType.PLAYER_ONE
            every { criteria.suitPriorities } returns listOf()
            every { playerOne.discard(capture(discardPair)) } answers { discardPair.captured }

            game.nextRound()

            assertThat(discardPair.captured).isEqualTo(Pair(card, card))
        }

        @Test
        fun `not increment player two's discard pile when player one wins the round`() {
            val card = GameCardMother.create(GameCardSuit.DIAMONDS, GameCardRank.TWO)
            val discardPair = slot<Pair<GameCard, GameCard>>()
            every { playerOne.play() } returns card
            every { playerTwo.play() } returns card
            every { criteria.roundWinner(any()) } returns GamePlayerType.PLAYER_ONE
            every { criteria.suitPriorities } returns listOf()
            every { playerTwo.discard(capture(discardPair)) } answers { discardPair.captured }

            game.nextRound()

            assertThat(discardPair.isCaptured).isFalse
        }

        @Test
        fun `increment player two's discard pile when player two wins the round`() {
            val card = GameCardMother.create(GameCardSuit.DIAMONDS, GameCardRank.TWO)
            val discardPair = slot<Pair<GameCard, GameCard>>()
            every { playerOne.play() } returns card
            every { playerTwo.play() } returns card
            every { criteria.roundWinner(any()) } returns GamePlayerType.PLAYER_TWO
            every { criteria.suitPriorities } returns listOf()
            every { playerTwo.discard(capture(discardPair)) } answers { discardPair.captured }

            game.nextRound()

            assertThat(discardPair.captured).isEqualTo(Pair(card, card))
        }

        @Test
        fun `not increment player one's discard pile when player two wins the round`() {
            val card = GameCardMother.create(GameCardSuit.DIAMONDS, GameCardRank.TWO)
            val discardPair = slot<Pair<GameCard, GameCard>>()
            every { playerOne.play() } returns card
            every { playerTwo.play() } returns card
            every { criteria.roundWinner(any()) } returns GamePlayerType.PLAYER_TWO
            every { criteria.suitPriorities } returns listOf()
            every { playerOne.discard(capture(discardPair)) } answers { discardPair.captured }

            game.nextRound()

            assertThat(discardPair.isCaptured).isFalse
        }

    }

}
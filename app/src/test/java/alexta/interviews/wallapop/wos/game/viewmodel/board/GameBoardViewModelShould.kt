package alexta.interviews.wallapop.wos.game.viewmodel.board

import alexta.interviews.wallapop.core.game.application.find.GameFinder
import alexta.interviews.wallapop.core.game.domain.GameIdMother
import alexta.interviews.wallapop.core.game.domain.GameMother
import alexta.interviews.wallapop.wos.share.framework.lifecycle.LifecycleUnitTestCase
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GameBoardViewModelShould : LifecycleUnitTestCase<GameBoardOperation>() {

    private val finder = mockk<GameFinder>(relaxUnitFun = true)
    private lateinit var viewModel: GameBoardViewModel

    @BeforeEach
    override fun setUp() {
        super.setUp()
        clearMocks(finder)
        viewModel = GameBoardViewModel(finder)
        viewModel.operation.observeForever(observer)
    }

    @Nested
    internal inner class Start {

        @Test
        fun `retrieve current game once`() {
            val gameId = GameIdMother.create().value
            every { finder.find(any()) } returns null

            viewModel.startGame(gameId)

            verify(exactly = 1) { finder.find(gameId) }
        }

        @Test
        fun `not notify about current game has been started when game has not be found`() {
            val gameId = GameIdMother.create().value
            every { finder.find(gameId) } returns null

            viewModel.startGame(gameId)

            verify(exactly = 0) { observer.onChanged(any()) }
        }

        @Test
        fun `notify about current game has been started once`() {
            val gameId = GameIdMother.create().value
            val game = GameMother.create(gameId)
            every { finder.find(gameId) } returns game

            viewModel.startGame(gameId)

            verify(exactly = 1) { observer.onChanged(any()) }
        }

        @Test
        fun `notify about current game has been started`() {
            val gameId = GameIdMother.create().value
            val game = GameMother.create(gameId)
            val operation = slot<GameBoardOperation>()
            every { finder.find(gameId) } returns game
            every { observer.onChanged(capture(operation)) } answers { operation.captured }

            viewModel.startGame(gameId)

            assertThat(operation.captured).isInstanceOf(GameBoardOperation.OnGameStarted::class.java)
        }
    }

    @Nested
    internal inner class Reset {

        @Test
        fun `not notify about current game has been reset when game has not been started`() {
            viewModel.resetGame()

            verify(exactly = 0) { observer.onChanged(any()) }
        }

        @Test
        fun `notify about current game has been reset when game already started`() {
            val gameId = GameIdMother.create().value
            val game = GameMother.create(gameId)
            val operations = mutableListOf<GameBoardOperation>()
            val operation = slot<GameBoardOperation>()
            every { finder.find(gameId) } returns game
            every { observer.onChanged(capture(operation)) } answers { operations.add(operation.captured) }
            viewModel.startGame(gameId)

            viewModel.resetGame()

            assertThat(operations[1]).isInstanceOf(GameBoardOperation.OnGameReset::class.java)
        }

    }

    @Nested
    internal inner class Next {

        @Test
        fun `not notify about current game next round has been played when game has not been started`() {
            viewModel.playNextRound()

            verify(exactly = 0) { observer.onChanged(any()) }
        }

        @Test
        fun `notify about current game has been next round has been played when game already started`() {
            val gameId = GameIdMother.create().value
            val game = GameMother.create(gameId)
            val operations = mutableListOf<GameBoardOperation>()
            val operation = slot<GameBoardOperation>()
            every { finder.find(gameId) } returns game
            every { observer.onChanged(capture(operation)) } answers { operations.add(operation.captured) }
            viewModel.startGame(gameId)

            viewModel.playNextRound()

            assertThat(operations[1]).isInstanceOf(GameBoardOperation.OnGameRoundPlayed::class.java)
        }
    }

    @Nested
    internal inner class End {

        @Test
        fun `not notify about current has been ended when game has not been started`() {
            viewModel.playNextRound()

            verify(exactly = 0) { observer.onChanged(any()) }
        }

        @Test
        fun `notify about current game has been ended when all rounds has been played`() {
            val gameId = GameIdMother.create().value
            val game = GameMother.create(gameId)
            val operations = mutableListOf<GameBoardOperation>()
            val operation = slot<GameBoardOperation>()
            every { finder.find(gameId) } returns game
            every { observer.onChanged(capture(operation)) } answers { operations.add(operation.captured) }
            viewModel.startGame(gameId)

            while (game.nextRound() != null) {
                viewModel.playNextRound()
            }

            assertThat(operations[operations.size.minus(1)])
                .isInstanceOf(GameBoardOperation.OnGameEnded::class.java)
        }

    }

}
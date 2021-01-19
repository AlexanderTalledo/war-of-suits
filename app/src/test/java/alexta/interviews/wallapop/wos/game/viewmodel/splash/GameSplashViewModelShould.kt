package alexta.interviews.wallapop.wos.game.viewmodel.splash

import alexta.interviews.wallapop.core.game.application.create.GameCreator
import alexta.interviews.wallapop.wos.share.framework.lifecycle.LifecycleUnitTestCase
import io.mockk.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameSplashViewModelShould : LifecycleUnitTestCase<GameSplashOperation>() {

    private val creator = mockk<GameCreator>(relaxUnitFun = true)
    private lateinit var viewModel: GameSplashViewModel

    @BeforeEach
    override fun setUp() {
        super.setUp()
        clearMocks(creator)
        viewModel = GameSplashViewModel(creator)
        viewModel.operation.observeForever(observer)
    }

    @Test
    fun `create a new game once`() {
        viewModel.createNewGame()

        verify(exactly = 1) { creator.create(any()) }
    }

    @Test
    fun `notify about a new game has been created`() {
        val operation = slot<GameSplashOperation>()
        every { observer.onChanged(capture(operation)) } answers { operation.captured }

        viewModel.createNewGame()

        assertThat(operation.captured).isInstanceOf(GameSplashOperation.OnGameCreated::class.java)
    }

    @Test
    fun `provide game id when a new game has been created`() {
        val id = slot<String>()
        val operation = slot<GameSplashOperation>()
        every { creator.create(capture(id)) } answers { id.captured }
        every { observer.onChanged(capture(operation)) } answers { operation.captured }

        viewModel.createNewGame()

        assertThat((operation.captured as GameSplashOperation.OnGameCreated).gameId).isEqualTo(id.captured)
    }

}
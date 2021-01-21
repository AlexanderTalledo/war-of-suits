package alexta.interviews.wallapop.core.game.infrastructure

import alexta.interviews.wallapop.core.game.domain.GameDataSource
import alexta.interviews.wallapop.core.game.domain.GameIdMother
import alexta.interviews.wallapop.core.game.domain.GameMother
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameRepositoryShould {

    private val dataSource = mockk<GameDataSource>(relaxUnitFun = true)
    private val repository = GameRepository(dataSource)

    @BeforeEach
    internal fun setup() {
        clearMocks(dataSource)
    }

    @Test
    internal fun `save a new game once`() {
        val game = GameMother.create()

        repository.save(game)

        verify(exactly = 1) { dataSource.save(game) }
    }

    @Test
    internal fun `find an existing game once`() {
        val id = GameIdMother.create()
        val game = GameMother.create(id.value)
        every { dataSource.find(id) } returns game

        repository.find(id)

        verify(exactly = 1) { dataSource.find(id) }
    }

}
package alexta.interviews.wallapop.core.game.domain

import alexta.interviews.wallapop.core.game.infrastructure.GameRepository
import alexta.interviews.wallapop.shared.domain.errors.DomainError
import io.mockk.clearMocks
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import kotlin.reflect.KClass

private const val SAVE_TIMES_DEFAULT = 1
private const val FIND_TIMES_DEFAULT = 1

abstract class GameModuleUnitTestCase {

    internal val repository = mockk<GameRepository>(relaxUnitFun = true)

    @BeforeEach
    internal fun setup() {
        clearMocks(repository)
    }

    internal inline fun <reified E : DomainError> shouldHaveFailed(
        error: Throwable,
        expectedErrorKClass: KClass<E>,
        expectedErrorMessage: String
    ) {
        assertThat(error)
            .isExactlyInstanceOf(expectedErrorKClass.java)
            .hasMessage(expectedErrorMessage)
    }

    internal fun shouldHaveCreated(game: Game, expectedTimes: Int = SAVE_TIMES_DEFAULT) {
        verify(exactly = expectedTimes) { repository.save(game) }
    }

    internal fun shouldHaveFound(id: GameId, expectedTimes: Int = FIND_TIMES_DEFAULT) {
        verify(exactly = expectedTimes) { repository.find(id) }
    }

}
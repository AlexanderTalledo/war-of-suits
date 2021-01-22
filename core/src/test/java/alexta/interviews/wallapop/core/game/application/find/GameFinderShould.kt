package alexta.interviews.wallapop.core.game.application.find

import alexta.interviews.wallapop.core.game.domain.GameIdMother
import alexta.interviews.wallapop.core.game.domain.GameModuleUnitTestCase
import alexta.interviews.wallapop.core.game.domain.GameMother
import alexta.interviews.wallapop.shared.domain.errors.InvalidValue
import io.mockk.every
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameFinderShould : GameModuleUnitTestCase() {

    private val finder = GameFinder(repository)

    @ParameterizedTest
    @ValueSource(
        strings = [
            "",
            " ",
            "adhjsfhasdhu",
            "898dsf69a8dsaf8a",
            "bf36b63d-c875-45e3-8c6d-"
        ]
    )
    internal fun `throw invalid value error when given game id is invalid`(id: String) {
        val error = catchThrowable { finder.find(id) }

        shouldHaveFailed(
            error,
            InvalidValue::class,
            "Invalid value: $id"
        )
    }

    @Test
    internal fun `find a game once`() {
        val id = GameIdMother.create()
        val game = GameMother.create(id.value)
        every { repository.find(id) } returns game

        finder.find(id.value)

        shouldHaveFound(id)
    }

}
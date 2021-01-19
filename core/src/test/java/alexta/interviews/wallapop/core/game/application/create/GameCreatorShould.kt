package alexta.interviews.wallapop.core.game.application.create

import alexta.interviews.wallapop.core.game.domain.GameModuleUnitTestCase
import alexta.interviews.wallapop.core.game.domain.GameMother
import alexta.interviews.wallapop.shared.domain.errors.InvalidValue
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameCreatorShould : GameModuleUnitTestCase() {

    private val creator = GameCreator(repository)

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
        val error = catchThrowable { creator(id) }

        shouldHaveFailed(
            error,
            InvalidValue::class,
            "Invalid value: $id"
        )
    }

    @Test
    internal fun `create a new game once`() {
        val game = GameMother.create()

        creator(game.id.value)

        shouldHaveCreated(game)
    }

}
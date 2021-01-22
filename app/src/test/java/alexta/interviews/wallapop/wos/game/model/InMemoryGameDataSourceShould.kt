package alexta.interviews.wallapop.wos.game.model

import alexta.interviews.wallapop.core.game.domain.GameIdMother
import alexta.interviews.wallapop.core.game.domain.GameMother
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class InMemoryGameDataSourceShould {

    private val dataSource = InMemoryGameDataSource()

    @Test
    fun `save a new game`() {
        val game = GameMother.create()

        dataSource.save(game)
    }

    @Test
    fun `find an already existing game`() {
        val expectedGame = GameMother.create()
        dataSource.save(expectedGame)

        val game = dataSource.find(expectedGame.id)

        assertThat(game).isEqualTo(expectedGame)
    }

    @Test
    fun `not found a non existing game`() {
        val id = GameIdMother.create()

        val game = dataSource.find(id)

        assertThat(game).isNull()
    }

}
package alexta.interviews.wallapop.wos.game.model

import alexta.interviews.wallapop.core.game.domain.GameMother
import org.junit.Test

class InMemoryGameDataSourceShould {

    private val dataSource = InMemoryGameDataSource()

    @Test
    fun `save a new game`() {
        val game = GameMother.create()

        dataSource.save(game)
    }

}
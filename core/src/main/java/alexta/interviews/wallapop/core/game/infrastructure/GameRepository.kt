package alexta.interviews.wallapop.core.game.infrastructure

import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameDataSource

class GameRepository(private val dataSource: GameDataSource) {

    internal fun save(game: Game) = dataSource.save(game)

}
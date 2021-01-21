package alexta.interviews.wallapop.wos.game.model

import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameDataSource
import alexta.interviews.wallapop.core.game.domain.GameId

class InMemoryGameDataSource : GameDataSource {

    private val games = mutableMapOf<String, Game>()

    override fun save(game: Game) = with(game) {
        games[id.value] = this
    }

    override fun find(id: GameId) = with(id) {
        games[value]
    }

}
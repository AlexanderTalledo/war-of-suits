package alexta.interviews.wallapop.wos.game.model

import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameDataSource

class InMemoryGameDataSource : GameDataSource {

    private val games = mutableMapOf<String, Game>()

    override fun save(game: Game) = with(game) {
        games[id.value] = this
    }

}
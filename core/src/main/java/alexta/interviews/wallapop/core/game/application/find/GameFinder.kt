package alexta.interviews.wallapop.core.game.application.find

import alexta.interviews.wallapop.core.game.domain.GameId
import alexta.interviews.wallapop.core.game.infrastructure.GameRepository

class GameFinder(private val repository: GameRepository) {

    fun find(id: String) = findGame(id)

    private fun findGame(id: String) = repository.find(GameId(id))

}
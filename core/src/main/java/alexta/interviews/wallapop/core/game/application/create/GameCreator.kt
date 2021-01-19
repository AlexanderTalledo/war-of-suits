package alexta.interviews.wallapop.core.game.application.create

import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameId
import alexta.interviews.wallapop.core.game.infrastructure.GameRepository

class GameCreator(private val repository: GameRepository) {

    fun create(id: String) {
        val game = createNewGame(id)
        saveGame(game)
    }

    private fun createNewGame(id: String) = Game(
        GameId(id)
    )

    private fun saveGame(game: Game) = repository.save(game)

}
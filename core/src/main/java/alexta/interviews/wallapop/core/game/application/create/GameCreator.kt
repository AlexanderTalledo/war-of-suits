package alexta.interviews.wallapop.core.game.application.create

import alexta.interviews.wallapop.core.game.domain.Game
import alexta.interviews.wallapop.core.game.domain.GameId
import alexta.interviews.wallapop.core.game.infrastructure.GameRepository

class GameCreator(private val repository: GameRepository) {

    operator fun invoke(id: String) {
        val game = create(id)
        save(game)
    }

    private fun create(id: String) = Game(
        GameId(id)
    )

    private fun save(game: Game) = repository.save(game)

}
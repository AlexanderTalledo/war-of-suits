package alexta.interviews.wallapop.core.game.application.create

import alexta.interviews.wallapop.core.game.domain.*
import alexta.interviews.wallapop.core.game.infrastructure.GameRepository

private const val PLAYER_ONE_NAME = "Xavier"
private const val PLAYER_TWO_NAME = "Magneto"

class GameCreator(private val repository: GameRepository) {

    fun create(id: String) {
        val game = createNewGame(id)
        saveGame(game)
    }

    private fun createNewGame(id: String) = Game(
        GameId(id),
        GameDeck(),
        GameRoundCriteria(),
        GamePlayer(GamePlayerName(PLAYER_ONE_NAME), GamePlayerType.PLAYER_ONE),
        GamePlayer(GamePlayerName(PLAYER_TWO_NAME), GamePlayerType.PLAYER_TWO)
    )

    private fun saveGame(game: Game) = repository.save(game)

}
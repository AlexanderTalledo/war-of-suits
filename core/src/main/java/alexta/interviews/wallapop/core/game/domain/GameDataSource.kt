package alexta.interviews.wallapop.core.game.domain

interface GameDataSource {

    fun save(game: Game)

    fun find(id: GameId): Game?

}
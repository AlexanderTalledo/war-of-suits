package alexta.interviews.wallapop.core.game.domain

import java.util.*

class Game(val id: GameId) {

    override fun equals(other: Any?): Boolean {
        if (null == other) return false
        if (this.javaClass != other.javaClass) return false
        if (this === other) return true
        return with(other as Game) { id == this.id }
    }

    override fun hashCode() = Objects.hash(id)

}
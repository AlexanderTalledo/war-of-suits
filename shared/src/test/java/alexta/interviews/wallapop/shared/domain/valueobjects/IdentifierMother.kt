package alexta.interviews.wallapop.shared.domain.valueobjects

object IdentifierMother {

    fun random(): String = MotherCreator.random()
        .internet()
        .uuid()

}
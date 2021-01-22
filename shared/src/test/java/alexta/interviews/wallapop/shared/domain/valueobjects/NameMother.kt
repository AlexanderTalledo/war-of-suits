package alexta.interviews.wallapop.shared.domain.valueobjects

object NameMother {

    fun random(): String = MotherCreator.random().name().firstName()

}
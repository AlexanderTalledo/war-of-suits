package alexta.interviews.wallapop.shared.domain.valueobjects

import com.github.javafaker.Faker

object MotherCreator {

    private val faker = Faker()

    internal fun random() = faker

}
package alexta.interviews.wallapop.shared.domain.utils

import java.util.*

object IdentifierUtils {

    fun generate() = UUID.randomUUID().toString()

    fun isValid(uuid: String) = try {
        UUID.fromString(uuid)
        true
    } catch (throwable: Throwable) {
        false
    }

}
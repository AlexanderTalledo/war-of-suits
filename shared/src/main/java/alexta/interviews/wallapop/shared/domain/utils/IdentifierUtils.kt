package alexta.interviews.wallapop.shared.domain.utils

import java.util.*

object IdentifierUtils {

    internal fun create() = UUID.randomUUID().toString()

    internal fun isValid(uuid: String) = try {
        UUID.fromString(uuid)
        true
    } catch (throwable: Throwable) {
        false
    }

}
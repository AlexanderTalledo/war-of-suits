package alexta.interviews.wallapop.shared.domain.errors

abstract class DomainError(message: String?) : Exception(message)

class InvalidValue(value: String) : DomainError("Invalid value: $value")
package core.menu.validation

sealed class ValidationError(
    val message: String
) {
    object NotDigit: ValidationError("Следует вводить цифру")
    object WrongDigit: ValidationError("Такой цифры нет")
}

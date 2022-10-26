package utils

enum class ErrMessage(private val message: String) {

    ERROR_EMPTY("Ввод не должен быть пустым!"),
    ERROR_NOT_INT("Введите целое число соответствующее пункту меню:"),
    ERROR_OUT_OF_RANGE("Данного пункта в меню нет. Введите корректное занчение:");

    override fun toString(): String {
        return message
    }
}

enum class RequestMessage(private val requestMessage: String) {

    ENTER_TITLE("Введите название:"),
    ENTER_TEXT("Введите текст:"),
    ENTER_ANY_KEY("Для возврата в предыдущее меню введите любую строку или нажмите Enter");

    override fun toString(): String {
        return requestMessage
    }
}
enum class Strings(private val string: String) {
    COMMAND_EXIT("Выход"),
    COMMAND_ENTER("Введите номер команды:"),

    ARCHIVE_MAKE("0. Создать архив"),
    ARCHIVE_INTRODUCE("Вы находитесь в архиве - "),
    ARCHIVE_MAKE_NAME("Введите название архива:"),
    ARCHIVE_LIST("Список архивов:"),

    ERROR_INCORRECT_ENTER("Некорректный ввод. Ожидается номер команды. Повторите ввод команды:"),
    ERROR_EMPTY_INPUT("Пустой ввод недопустим. Повторите ввод:"),
    ERROR_WRONG_COMMAND("Такой комманды не существует. Повторите ввод команды:"),

    NOTE_MAKE("0. Создать заметку"),
    NOTE_MAKE_NAME("Введите название заметки:"),
    NOTE_INTRODUCE("Вы находитесь в заметке - "),
    NOTE_READ("0. Прочитать заметку"),
    NOTE_FILL_COMMAND("0. Заполнить заметку"),
    NOTE_FILL("Введите текст заметки"),
    NOTE_SHOW_CONTENT("Текст заметки "),

    PROGRAM_HELLO("Добро пожаловать в программу \"Заметки\"."),
    PROGRAM_GOODBYE("Программа \"Заметки\" заканчивает свою работу.")
    ;

    override fun toString(): String {
        return string
    }
}
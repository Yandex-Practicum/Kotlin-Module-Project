import java.util.*

class Input {
    private val scanner = Scanner(System.`in`)

    /* --- 2е навигационные функции --- */
    // 1. Шаблон для экранов просмотра либо создания содержимого
    fun create(
        article: () -> Unit,
        nameArchOrNotes: (s: String) -> Unit
    ) {
        article()
        nameArchOrNotes.invoke(inputStr())
    }

    // 2. Вывод на экран результатов проверки ввода на ошибки
    fun navigate(
        menu: () -> Unit, // вывод на экран ошибки
        choose: (n: Int) -> Unit, // или выполняем команду0
    ) {
        menu.invoke()
        when (val input = this.inputInt()) {
            -111 -> println("Ввод букв недопустим")
            -112 -> println("Ввод пустой строки недопустим")
            -113 -> println("Ввод символов недопустим")
            else -> choose.invoke(input)
        }
    }

    /* --- Сама проверка ввода символов --- */
    // Ввод строки (символы запрещены)
    private fun inputInt(): Int {
        val command = scanner.nextLine()
        if (command.isEmpty()) return -112
        for (symbol in command) {
            if (symbol.isLetter()) return -111
            else if (!symbol.isDigit()) return -113
        }
        return command.toInt()
    }

    // Ввод строки (символы разрешены)
    private fun inputStr(): String {
        var command2 = scanner.nextLine()
        while (command2.isEmpty()) {
            println("Ввод пустой строки запрещен. Введите заново!")
            command2 = scanner.nextLine()
        }
        return command2
    }
}
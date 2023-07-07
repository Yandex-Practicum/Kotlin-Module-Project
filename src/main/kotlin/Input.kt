import java.util.*
class Input {
    private val scanner = Scanner(System.`in`)
    /* --- 2е навигационные функции --- */
    // 1. Шаблон для экранов просмотра либо создания содержимого
    fun create(
        article:()->Unit,
        pass:(s:String) -> Unit
    ){
        article()
        pass.invoke(inputStr())
    }
    // 2. Вывод на экран результатов проверки ввода на ошибки
    fun navigate(
        menu: () -> Unit, // вывод на экран ошибки
        choose: (n:Int) -> Unit, // или выполняем команду
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
        if(command.isEmpty()) return -112
        for (symbol in command) {
            if (symbol.isLetter()) return -111
            else if(!symbol.isDigit()) return -113
        }
        return command.toInt()
    }
    // Ввод строки (символы разрешены)
    private fun inputStr():String{
        return scanner.nextLine()
    }
}
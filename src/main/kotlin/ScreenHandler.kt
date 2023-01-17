import java.util.*

open class ScreenHandler {
    val wrongDigit = "Нет такого элемента, попробуйте снова."
    val notDigit = "Ошибка ввода: Вы ввели букву. Нужно ввести цифру."
    val scanner = Scanner(System.`in`)

    fun exit() {
        return
    }

    fun printMenu(title: String, list: List<Any>) {
        println(title)
        list.forEachIndexed { index, it ->
            println("${index + 1}. ${it.toString()}")
        }
        println("${list.size + 1}. Выход")
    }

    fun inputCheck(menu: List<Any> = emptyList(), currentScreen: Screens): Int {
        var bufer: Int? = null
        if (menu.isEmpty() && currentScreen == Screens.SHOW_NOTE) {
            println("Введите цифру 0 для выхода.")
            do {
                while (!scanner.hasNextInt()) {
                    println(notDigit)
                    scanner.next()
                }
                bufer = scanner.nextInt()
                if (bufer != 0) {
                    println(wrongDigit)
                    continue
                }
            } while (bufer != 0)
            return bufer
        } else {
            while (true) {
                while (!scanner.hasNextInt()) {
                    println(notDigit)
                    scanner.next()
                }
                bufer = scanner.nextInt()
                if (bufer !in 0..menu.size + 1) {
                    println(wrongDigit)
                    continue
                } else {
                    return bufer
                }
            }
        }
    }
}
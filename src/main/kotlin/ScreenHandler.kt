import java.util.*

open class ScreenHandler {
    val wrongDigit = "Такого элемента не существует, попробуйте снова."
    val notDigit = "Введите цифру, а не букву."

    val scanner = Scanner(System.`in`)

    fun printMenu(title: String, list: List<Any>) {
        println(title)
        list.forEachIndexed { index, it ->
            println("${index + 1}. ${it.toString()}")
        }
        println("${list.size + 1}. Выход")
    }

    fun inputCheck (menu: List<Any> = emptyList(), currentScreen: Screens) : Int {
        var temp: Int? = null
        if (menu.isEmpty() && currentScreen == Screens.SHOW_NOTE) {
            println("Нажмите 0 для выхода.")
            do {
                while (!scanner.hasNextInt()) {
                    println(notDigit)
                    scanner.next()
                }
                temp = scanner.nextInt()
                if (temp != 0) {
                    println(wrongDigit)
                    continue
                }
            } while (temp != 0)
            return temp
        } else {
            while (true) {
                while (!scanner.hasNextInt()) {
                    println(notDigit)
                    scanner.next()
                }
                temp = scanner.nextInt()
                if (temp !in 0..menu.size + 1) {
                    println(wrongDigit)
                    continue
                } else {
                    return temp
                }
            }
        }
    }

    fun exitProgram () {
        return
    }
}
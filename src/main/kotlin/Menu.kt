import java.util.Scanner

abstract class Menu<T>(protected val items: List<T>, protected val header: String) {
    protected val scanner = Scanner(System.`in`)

    open fun show() {
        while (true) {
            printMenu()
            when (val input = readInput()) {
                0 -> if (createItem()) continue else return
                in 1..items.size -> if (selectItem(items[input - 1])) continue else return
                items.size + 1 -> return
                else -> showError("Неверный пункт меню")
            }
        }
    }

    protected open fun printMenu() {
        println(header)
        println("0. Создать")
        items.forEachIndexed { index, item -> println("${index + 1}. ${getDisplayName(item)}") }
        println("${items.size + 1}. Выход")
    }

    protected fun readInput(): Int {
        while (true) {
            try {
                return scanner.nextLine().toInt()
            } catch (e: NumberFormatException) {
                showError("Введите число")
            }
        }
    }

    protected fun showError(message: String) {
        println("Ошибка: $message")
    }

    abstract fun getDisplayName(item: T): String
    abstract fun createItem(): Boolean
    abstract fun selectItem(item: T): Boolean
}
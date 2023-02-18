import java.util.Scanner

abstract class Menu {
    abstract val title: String
    abstract val dataList: MutableList<MenuData>
    val scanner = Scanner(System.`in`)


    fun start() {
        while (true) {
            if (!selectAction()) {
                break
            }
        }
    }

    private fun selectAction(): Boolean {
        while (true) {
            println(title)
            dataList.forEachIndexed { index, choice -> println("\t$index. $choice") }
            print("Введите цифру: ")
            val inputChoice: String = scanner.nextLine()
            if (match(inputChoice)) {
                return dataList.elementAt(inputChoice.toInt()).action()
            }
            println("Неверный ввод. Попробуйте еще раз:")
        }
    }

    private fun match(value: String): Boolean {
        val digit = value.toIntOrNull() ?: return false
        if (!dataList.indices.contains(digit)) return false
        return true
    }

    open fun exit(): Boolean {
        return false
    }
}

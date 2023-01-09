import java.util.*

abstract class Menu {

    val List<String>.firstIndex: Int
        get() = if (this.isNotEmpty()) 0 else -1

    abstract val menuItems: List<String>
    abstract val header: String

    abstract fun runActions(response: String): Boolean
    abstract fun exit()
    
    private fun printMenu(header: String) {
        println(header)
        for ((number, item) in menuItems.withIndex()) {
            println("${number}. $item")
        }
    }

    fun execute() {
        var flag = true
        while (flag) {
            printMenu(header)
            val response = Scanner(System.`in`).nextLine()
            if (!response.matches("0|([1-9]\\d*)".toRegex())) {
                println("Пожалуста, введите цифру, соответствующую пунктам меню...")
            } else if (response.toInt() !in menuItems.indices) {
                println("Пункта меню с подобной цифрой не существует. Введите корректное значение...")
            } else {
                flag = runActions(response)
            }
        }
    }
}

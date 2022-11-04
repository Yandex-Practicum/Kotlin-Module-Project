import java.util.*

abstract class Screen<T> {
    abstract val list: MutableList<T>
    fun navigate() {
        printMenu(list)
        var input = Scanner(System.`in`).nextLine()
        while (input != Input.EXIT.code) {
            when (input) {
                Input.CREATE.code -> {
                    create()
                }
                else -> {
                    val param = input.toIntOrNull()
                    when {
                        param == null -> println("Вы не ввели число!")
                        (param - 2) >= 0 && (param - 2) < list.size -> {
                            val element = list[(param - 2)]
                            show(element)
                        }
                        else -> println("Такого пункта в меню нет!")
                    }
                }
            }
            printMenu(list)
            input = Scanner(System.`in`).nextLine()
        }
    }

    abstract fun create()
    abstract fun show(param: T)
    abstract fun printMenu(list: MutableList<T>)
}
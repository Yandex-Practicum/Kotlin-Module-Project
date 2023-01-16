import java.util.Scanner

open class ScreenHandler {

    private val scanner = Scanner(System.`in`)

    protected fun printItems(title: String, list: List<Any>) {
        println(title)
        list.forEachIndexed { index, it ->
            println("${index + 1}. ${it.toString().take(10)}")
        }
        println("${list.size + 1}. Выход")
    }

    protected fun inputCheck(list: List<Any>): Int {
        while (true) {
            try {
                val input = scanner.nextLine().toInt()
                if (input < 0 || input > list.size + 1) {
                    println("Введенного числа нет с списке, повторите ввод!")
                } else {
                    return input
                }
            } catch (e: Exception) {
                println("Ошибка ввода. Ведите цифру от 0 до ${list.size + 1}:")
            }
        }
    }

    protected fun exit() {
        println("Выход из приложения...")
        return
    }

    protected fun noteExit() {
        while (scanner.hasNext()) {
            if (scanner.nextLine() == "0") break
        }
    }
}
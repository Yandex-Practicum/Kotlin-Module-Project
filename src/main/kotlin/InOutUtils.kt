import java.util.*

class InOutUtils {
    private val input = Scanner(System.`in`)

    fun readCommand(max: Int): Int {
        while (true) {
            val input = validateInput(input.nextLine())
            if (input <= -1 || input > max) {
                println("Число должно быть от 0 до $max. Повторите ввод:")
                continue
            }
            return input
        }
    }

    fun readString(): String {
        while (true) {
            val input = input.nextLine()
            if (input.isNullOrBlank()) {
                println("Ввод не должен быть пустым, повторите ввод: ")
                continue
            }
            return input
        }
    }

    fun showMenu(tittleScreen: String, commandList: List<String>) {
        println("======")
        println(tittleScreen)
        commandList.forEachIndexed { index, command ->
            println("$index. $command")
        }
        println("------")
        print("Введите пункт меню:")
    }

    fun endPrintScreen() {
        println("======\n")
    }

    private fun validateInput(input: String): Int {
        return input.toIntOrNull() ?: return -1
    }
}
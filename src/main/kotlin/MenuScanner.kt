import java.util.Scanner

class MenuScanner {
    val scanner = Scanner(System.`in`)

    fun getUserInput(): Int {
        while (true) {
            val input = scanner.nextLine()
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                println("Пожалуйста, введите число.")
            }
        }
    }

    fun printMenu(options: List<String>) {
        for ((index, option) in options.withIndex()) {
            println("${index + 1}. $option")
        }
    }
}
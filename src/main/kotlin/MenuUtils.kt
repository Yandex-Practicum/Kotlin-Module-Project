import java.util.Scanner

class MenuUtils {
    private val scanner = Scanner(System.`in`)

    fun readInput(): Int {
        while (true) {
            val input = scanner.nextLine()
            try {
                return input.toInt()
            } catch (e: NumberFormatException) {
                println("Пожалуйста, введите число.")
            }
        }
    }
}
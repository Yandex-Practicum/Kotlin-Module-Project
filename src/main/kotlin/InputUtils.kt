import java.util.Scanner

class InputUtils {
    private val scanner = Scanner(System.`in`)

    fun readInt(): Int? {
        val line = scanner.nextLine()
        return line.toIntOrNull()
    }

    fun readString(prompt: String): String {
        while (true) {
            println(prompt)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) {
                return input
            }
            println("Ошибка: поле не может быть пустым. Попробуйте снова.")
        }
    }
}
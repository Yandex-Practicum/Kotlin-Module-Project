import java.util.Scanner

class MenuHelper {
    companion object {
        fun showMenu(title: String, options: List<String>) {
            println("$title:\n")
            for ((index, option) in options.withIndex()) {
                println("$index. $option")
            }
            println("Введите команду:")
        }

        fun readChoice(maxChoice: Int): Int {
            return try {
                val scanner = Scanner(System.`in`).nextLine().toInt()
                if (scanner in 0..maxChoice) scanner else -1
            } catch (e: NumberFormatException) {
                -1
            }
        }
    }
}
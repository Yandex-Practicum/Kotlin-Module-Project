import java.util.Scanner

class ConsoleUtils {
    companion object {
        private var scanner = Scanner(System.`in`)

        fun write(text: String) {
            println(text)
        }

        fun read(): String {
            return scanner.nextLine()
        }

        fun showMenu(text: String) {
            write("---------------------------------------------------")
            println("Меню: $text")
            write("---------------------------------------------------")
        }
    }
}
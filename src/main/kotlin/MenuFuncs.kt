import java.util.Scanner
import kotlin.system.exitProcess

object MainFuncs {
    private val scanner = Scanner(System.`in`)


    fun displayMenu(
        title: String,
        options: Array<String>,
        actions: Array<() -> Unit>,
        onExit: () -> Unit
    ) {
        while (true) {
            println("\n$title")
            for (i in options.indices) {
                println("${i + 1}. ${options[i]}")
            }
            println("0. Назад")

            val input = scanner.nextLine().trim()
            val choice = try {
                input.toInt()
            } catch (e: NumberFormatException) {
                -1
            }

            if (choice == 0 && title == "Меню архивов") {
                exitProcess(0)


            }
            else if (choice == 0){
                ArchiveManager.showMenu()
                return
            }
            else if (choice in 1..options.size) {
                actions[choice - 1]()
            } else {
                println("Ошибка: выберите корректный номер.")
            }
        }
    }


    fun readInput(prompt: String): String {
        while (true) {
            println(prompt)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty())  {

                return input
            }
            println("Ошибка: поле не может быть пустым.")
        }
    }
}

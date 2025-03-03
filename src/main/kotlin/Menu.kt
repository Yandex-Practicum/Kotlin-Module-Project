import java.util.Scanner

class Menu (private val title: String) {
    val listOfCommands: MutableList<Pair<String, () -> Unit>> = mutableListOf()

    fun start() {
        while (true) {
            printMenu()
            val userInput: Int = getInput()
            if (userInput == listOfCommands.size) {
                break
            }
            listOfCommands[userInput].second()
        }
    }

    private fun getInput(): Int {
        while (true) {
            println("Введите команду:")
            val input: String = Scanner(System.`in`).nextLine()
            val menuCode: Int? = input.toIntOrNull()
            if (menuCode == null) {
                println("Введено не число. Пожалуйста, введите число:")
                printMenu()
                continue
            } else {
                if (menuCode < 0 || menuCode > listOfCommands.size) {
                    println("\nТакой цифры нет, необходимо ввести корректную цифру")
                    printMenu()
                    continue
                } else {
                    return menuCode
                }
            }
        }
    }

    private fun printMenu() {
        println(title)
        listOfCommands.forEachIndexed { index, pair -> println("$index. ${pair.first}") }
        println("${listOfCommands.size}. Выход")
    }
}

import java.util.Scanner

class Menu(private val screenName: String) {
    private val scanner = Scanner(System.`in`)
    private val commands = mutableListOf<MenuItem>()

    fun addCommand(name: String, action: () -> Unit) {
        commands.add(MenuItem(name, action))
    }

    fun showMenuScreen() {

        while (true) {
            screenOut()
            val choice = choice()
            if (choice == 0) {
                break
            } else if (choice in 1..commands.size) {
                commands[choice - 1].action()
            } else {
                println("Неверный ввод")

            }
        }
    }

    private fun choice(): Int {
        while (true) {
            print("Введите число: ")
            try {
                return scanner.nextLine().toInt()
            } catch (e: NumberFormatException) {
                println("Пожалуйста, введите число.")
            }
        }
    }
    private fun screenOut(){
        println("\n$screenName")
        commands.forEachIndexed { index, item ->
            println("${index + 1}. ${item.title}")
        }
        println("0. Выход")
    }
}

class MenuItem(val title: String, val action: () -> Unit)
import java.util.Scanner

class MenuNavigator {
    private val scanner = Scanner(System.`in`)

    fun showMenu(title: String, items: List<Pair<String, () -> Unit>>): Int {
        while (true) {
            println(title)
            items.forEachIndexed { index, (name, _) ->
                println("$index. $name")
            }

            print("Введите номер пункта меню: ")
            val input = scanner.nextLine()

            try {
                val choice = input.toInt()
                if (choice in 0 until items.size) {
                    items[choice].second()
                    return choice
                } else {
                    println("Неверный номер пункта меню. Пожалуйста, введите корректный номер.")
                }
            } catch (e: NumberFormatException) {
                println("Пожалуйста, введите цифру.")
            }
        }
    }

    fun readString(prompt: String): String {
        print(prompt)
        return scanner.nextLine()
    }
}
import java.util.Scanner

class Menu(val title: String) {
    private val options = mutableListOf<Pair<String, () -> Unit>>()
    private val scanner = Scanner(System.`in`)

    fun addOption(name: String, action: () -> Unit) {
        options.add(Pair(name, action))
    }

    fun show() {
        while (true) {
            println("\n=== $title ===")
            options.forEachIndexed { index, (name, _) ->
                println("$index. $name")
            }
            println("${options.size}. Выход")

            print("Выберите пункт: ")
            val input = scanner.nextLine()

            if (input == options.size.toString()) {
                println("Выход...")
                break
            }

            val choice = input.toIntOrNull()
            if (choice == null || choice !in options.indices) {
                println("Ошибка: введите число от 0 до ${options.size - 1}")
                continue
            }

            options[choice].second.invoke()
        }
    }
}
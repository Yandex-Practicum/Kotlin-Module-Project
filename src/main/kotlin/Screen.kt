import java.util.Scanner

class Screen(val title: String, val options: List<Pair<String, () -> Unit>>) {

    private val scanner = Scanner(System.`in`)

    fun show() {
        while (true) {
            println("\n=== $title ===")
            options.forEachIndexed { index, option ->
                println("$index. ${option.first}")
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
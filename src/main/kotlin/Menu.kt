import java.util.Scanner

class Menu(
    private val title: String,
    private val items: List<Pair<String, () -> Boolean>>
) {
    private val scanner = Scanner(System.`in`)

    fun show(exitText: String = "Выход"): Boolean {
        while (true) {
            println("\n$title")
            items.forEachIndexed { i, (name, _) -> println("${i + 1}. $name") }
            println("0. $exitText")
            print("Выберите пункт: ")

            when (val input = scanner.nextLine().toIntOrNull()) {
                null -> {
                    println("❌ Нужно ввести число")
                    continue
                }
                0 -> return false
                in 1..items.size -> {
                    val shouldContinue = items[input - 1].second()
                    if (!shouldContinue) return false
                }
                else -> println("❌ Неверный номер")
            }
        }
    }
}
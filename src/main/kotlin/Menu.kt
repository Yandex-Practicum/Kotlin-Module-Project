data class MenuItem(
    val title: String,
    val action: () -> NavCommand
)

class Menu(
    private val header: String,
    private val items: List<MenuItem>,
    private val input: InputReader
) {
    fun run(): NavCommand {
        while (true) {
            if (header.isNotBlank()) println(header)
            items.forEachIndexed { index, item ->
                println("$index.${item.title}")
            }
            val raw = input.readLine("Выберите пункт:").trim()
            val choice = raw.toIntOrNull()

            if (choice == null) {
                println("Нужно ввести цифру. Попробуйте еще раз.\n")
                continue
            }
            if (choice !in items.indices) {
                println("Нет пункта с номером $choice. Попробуйте ещё раз.\n")
                continue
            }

            println()
            return items[choice].action()

        }
    }
}
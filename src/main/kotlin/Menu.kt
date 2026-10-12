import java.util.Scanner

class Menu(
    private val scanner: Scanner
) {
    data class MenuItem(
        val title: String,
        val action: () -> Unit
    )

    val items: MutableList<MenuItem> = mutableListOf()

    fun addItem(title: String, action: () -> Unit) {
        items.add(MenuItem(title, action))
    }

    fun clearItems() {
        items.clear()
    }

    fun readText(prompt: String): String {
        print(prompt)
        return scanner.nextLine()
    }

    fun showMenu(
        title: String,
        zeroLabel: String,
        onZero: () -> Unit
    ) {
        while (true) {
            println()
            println("=== $title ===")

            items.forEachIndexed { index, item ->
                println("${index + 1}. ${item.title}")
            }

            println("0. $zeroLabel")
            print("Выберите действие: ")

            val choice = scanner.nextLine().toIntOrNull()

            when {
                choice == null -> {
                    println("Введите номер пункта цифрами")
                }

                choice == 0 -> {
                    onZero()
                    return
                }

                choice in 1..items.size -> {
                    val action = items[choice - 1].action
                    action()
                    return
                }

                else -> {
                    println("Такого пункта нет")
                }
            }
        }
    }
}
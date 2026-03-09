import java.util.Scanner

class Menu(private val title: String) {

    data class MenuItem(val name: String, val action: () -> Unit)

    private val scanner = Scanner(System.`in`)
    private val items = mutableListOf<MenuItem>()

    fun addItem(name: String, action: () -> Unit) {
        items.add(MenuItem(name, action))
    }

    fun show() {
        println(title)

        for (i in items.indices) {
            println("$i. ${items[i].name}")
        }

        while (true) {
            val input = scanner.nextLine()
            val number = input.toIntOrNull()

            when {
                number == null -> {
                    println("Введите цифру")
                    continue
                }
                number !in items.indices -> {
                    println("Нет такого пункта")
                    continue
                }
                else -> {
                    items[number].action.invoke()
                    break
                }
            }
        }
    }
}
class Menu(
    private val title: String,
    private val items: MutableList<String>
) {

    fun show(): Int {
        while (true) {
            println()
            println(title)

            items.forEachIndexed { index, item ->
                println("$index. $item")
            }

            print("Выберите пункт: ")

            val input = readln()
            val choice = input.toIntOrNull()

            if (choice == null) {
                println("Ошибка: введите номер пункта цифрой.")
                continue
            }

            if (choice !in items.indices) {
                println("Ошибка: пункта с номером $choice нет.")
                continue
            }

            return choice
        }
    }
}
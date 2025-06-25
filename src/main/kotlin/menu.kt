class Menu(
    private val title: String,
    private val items: List<Pair<String, () -> Unit>>
) {
    fun show() {
        while (true) {
            println("$title")
            items.forEachIndexed { index, (label, _) -> println("$index. $label") }

            print("Выберите пункт: ")
            val input = readLine()

            val index = input?.toIntOrNull()

            if (index == null) {
                println("Ошибка: введите цифру, соответствующую пункту меню.")
            } else if (index !in items.indices) {
                println("Ошибка: такого пункта нет.")
            } else {
                items[index].second()
                break
            }
        }
    }
}
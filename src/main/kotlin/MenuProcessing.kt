class MenuItem(val text: String, val action: () -> Unit)

class MenuProcessing(
    private val title: String,
    private val menuItems: List<MenuItem>
) {
    fun show(): Boolean {
        println("\n=== $title ===")
        menuItems.forEachIndexed { index, item ->
            println("$index. ${item.text}")
        }
        println("Введите цифру нужного пункта:")

        val input = scanner.nextLine()
        val choice = input.toIntOrNull()

        if (choice == null) {
            println("Ошибка: Введите, пожалуйста, цифру, а не текст!")
            return true
        }

        if (choice !in menuItems.indices) {
            println("Ошибка: Пункта с таким номером не существует. Попробуйте еще раз.")
            return true
        }

        val selectedItem = menuItems[choice]

        if (selectedItem.text.contains("Выход", ignoreCase = true) || selectedItem.text.contains("Назад", ignoreCase = true)) {
            selectedItem.action()
            return false
        }

        selectedItem.action()
        return true
    }
}
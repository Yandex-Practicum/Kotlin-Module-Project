import java.util.Scanner

class MenuManager(private val scanner: Scanner) {

    fun showMenu(menuItems: List<Pair<String, () -> Unit>>) {
        while (true) {
            println("Выберите пункт меню:")
            menuItems.forEachIndexed { index, item ->
                println("$index. ${item.first}")
            }
            println("Введите номер пункта (или 'выход' для выхода):")
            val input = scanner.nextLine()

            if (input.lowercase() == "выход") {
                println("Выход из программы.")
                return
            }

            val index = input.toIntOrNull()
            if (index != null && index in menuItems.indices) {
                menuItems[index].second()
            } else {
                println("Неверный ввод. Пожалуйста, введите номер пункта.")
            }
        }
    }
}

import java.util.Scanner

class Menu(private val menuTitle: String) {
    private val menuItems = mutableListOf<MenuItem>()
    private val inputScanner = Scanner(System.`in`)

    fun addItem(itemTitle: String, onSelectAction: () -> Unit) {
        menuItems.add(MenuItem(itemTitle, onSelectAction))
    }

    fun display() {
        while (true) {
            println("\n$menuTitle")
            menuItems.forEachIndexed { itemIndex, menuItem ->
                println("${itemIndex + 1}. ${menuItem.title}")
            }
            print("Введите номер пункта меню: ")
            val userInput = inputScanner.nextLine()

            val selectedIndex = userInput.toIntOrNull()?.let { it - 1 }

            when {
                selectedIndex == null -> {
                    println("Ошибка: необходимо ввести числовое значение")
                }

                selectedIndex !in menuItems.indices -> {
                    println("Ошибка: пункт с номером ${selectedIndex + 1} не существует")
                }

                else -> {
                    menuItems[selectedIndex].onSelectAction()
                    break
                }
            }
        }
    }
}
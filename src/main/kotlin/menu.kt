import java.util.Scanner

class MenuItem(
    val title: String,
    val action: () -> Unit
)

class Menu(
    private val menuTitle: String,
    private val menuItems: List<MenuItem>
) {
    private val scanner = Scanner(System.`in`)


    fun show() {
        while (true) {
            println(menuTitle + ":")
            menuItems.forEachIndexed { index, item ->
                println("" + index + ". " + item.title)
            }
            print("Выберите пункт меню: ")
            val input = scanner.nextLine().trim()
            val choice = input.toIntOrNull()
            if (choice == null) {
                println("Введите цифру")
                continue
            }
            if (choice !in menuItems.indices) {
                println("Введите корректную цифру")
                continue
            }
            val selectedItem = menuItems[choice]
            selectedItem.action()
            if (choice == menuItems.lastIndex) {
                break
            }
        }
    }
}
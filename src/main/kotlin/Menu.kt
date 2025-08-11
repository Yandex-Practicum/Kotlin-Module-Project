import java.util.Scanner

abstract class Menu(protected val scanner: Scanner) {
    protected val items = mutableListOf<Menu.Item>()

    fun show(archives: HashMap<String, HashMap<String, String>>) {
        while (true) {
            items.forEach { item -> println("${item.index}. ${item.title}") }
            print("Ваш выбор: ")
            val choice = scanner.nextLine()

            try {
                val selectedIndex = choice.toInt()
                if (selectedIndex in 0 until items.size) {
                    items[selectedIndex].action(archives)
                    break
                } else {
                    println("Некорректный выбор. Попробуйте снова.")
                }
            } catch (e: NumberFormatException) {
                println("Пожалуйста, введите целое число.")
            }
        }
    }

    protected fun goBack(archives: HashMap<String, HashMap<String, String>>) {
        val mainMenu = MainMenu(scanner)
        mainMenu.show(archives)
    }



    data class Item(val index: Int, val title: String, val action: (HashMap<String, HashMap<String, String>>) -> Unit)
}
import java.util.Scanner

class Menu(private val text: String) {

    init {
        println(text)
    }

    class MenuItem(val name: String)

    private var menuItems: ArrayList<MenuItem> = arrayListOf()

    fun addMenuItem(item: MenuItem) {

        menuItems.add(item)
        println("  ${menuItems.indexOf(item)}. ${item.name}")

    }

    fun selectMenuItem(): MenuItem {

        val scanner = Scanner(System.`in`)
        var selectedNumber: Int? = null

        do {

            val userInput = scanner.nextLine()
            selectedNumber = userInput.toIntOrNull()

            if(selectedNumber == null)
                println("Неверный ввод '$userInput'. Введите номер пункта меню")

            else if (selectedNumber !in menuItems.indices)
                println("Неверный номер '$selectedNumber'. Такого пункта меню нет")

        } while ((selectedNumber == null) || (selectedNumber !in menuItems.indices))

        return menuItems[selectedNumber!!]
    }
}



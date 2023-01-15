class Navigator {
    private var isWork = true
    fun showMenu(source: NavigatorSource) {
        while (isWork) {
            val menu = source.getMenu().toMutableList()
            menu.add(MenuItem("Выход") { isWork = false })
            selectMenuItem(menu)
        }
    }

    private fun showMenuItems(menu: List<MenuItem>) {
        for ((index, menuItem) in menu.withIndex())
            println("${index}. ${menuItem.name}")
    }

    private fun selectMenuItem(menu: List<MenuItem>) {
        val selectedMenuItemIndex: Int

        while (true) {

            showMenuItems(menu)

            val inputString = inputString("Выберите цифру пункта меню")
            val selectedDigit = inputString.toIntOrNull()

            if (selectedDigit == null) {
                println("Вы ввели не цифру, обозначающую пункт выбранного меню.")
                continue
            }

            if (selectedDigit in menu.indices) {
                selectedMenuItemIndex = selectedDigit
                break
            } else
                println("Указанного номера пункта в меню нет.")
        }

        val menuItem = menu[selectedMenuItemIndex]
        menuItem.action(menuItem)
    }
}
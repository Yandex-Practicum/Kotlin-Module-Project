class Menu {
    private val menuFormatter = "%d - %s"
    val menuItems = mutableListOf<MenuItem>()
    fun renderArchives(list: List<Archives>) {
        menuItems.clear()
        println("Введите число для дальнейших действий")
        menuItems.add(MenuItem("Создать архив"))
        menuItems.addAll(list.map { MenuItem(it.name) })
        menuItems.add(MenuItem("Выход"))
        menuItems.forEachIndexed { index, archiveMenuItem ->
            println(String.format(menuFormatter, index, archiveMenuItem.title))
        }
    }

    fun rendernotes(list: List<Note>) {
        menuItems.clear()
        menuItems.add(MenuItem("Создать заметку"))
        menuItems.addAll(list.map { MenuItem(it.name) })
        menuItems.add(MenuItem("Назад"))
        menuItems.forEachIndexed { index, archiveMenuItem ->
            println(String.format(menuFormatter, index, archiveMenuItem.title))
        }
    }
}
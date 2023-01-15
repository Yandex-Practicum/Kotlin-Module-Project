class ArchiveStorage : NavigatorSource {
    private val archives = mutableListOf<Archive>()
    override fun getMenu(): List<MenuItem> {
        val menu = mutableListOf<MenuItem>()
        menu.add(MenuItem("Создать архив") { onCreate(it) })
        for (archive in archives)
            menu.add(MenuItem(archive.title) { onSelect(it) })
        return menu
    }

    private fun onCreate(menuItem: MenuItem) {
        val inputString = inputString("Введите название архива")
        archives.add(Archive(inputString))
    }

    private fun onSelect(menuItem: MenuItem) {
        val noteNavigator = Navigator()
        val archive = archives.find { it.title == menuItem.name }
        if (archive != null)
            noteNavigator.showMenu(archive)
        else
            println("Ошибка поиска архива ${menuItem.name}")
    }
}
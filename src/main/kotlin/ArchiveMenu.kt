class ArchiveMenu(
    private val archives: MutableList<Archive>

) {
    fun start() {

        while (true) {
            //var needRefresh = false
            val menuItems = mutableListOf<MenuScreen.MenuItem>()

            // 0 — создание архива
            menuItems.add(MenuScreen.MenuItem("Создать архив") {
                createArchive()
            //    needRefresh = true
            })

            // Существующие архивы
            archives.forEachIndexed { index, archive ->
                menuItems.add(MenuScreen.MenuItem(archive.name) {
                    NoteListScreen(archive).start()
                })
            }

            // Последним всегда выход
            menuItems.add(MenuScreen.exitItem {
                println("\nДо свидания!")
                kotlin.system.exitProcess(0)
            })

            val screen = MenuScreen(
                title = "Список архивов:",
                items = menuItems
            )

            screen.show()

        }
    }

    private fun createArchive() {
        println("Начало создания архива")
        println("\nВведите название архива:")
        val name = readNotEmptyString("Название архива не может быть пустым")
        println("Имя получено: '$name'")
        archives.add(Archive(name))
        println("Архив $name успешно создан.")
        println("Архив добавлен, теперь размер списка = ${archives.size}")

    }
}
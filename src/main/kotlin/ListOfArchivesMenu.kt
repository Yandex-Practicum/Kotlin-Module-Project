object ListOfArchivesMenu: Menu() {

    val archives: MutableList<Archive> = mutableListOf()
    override val menuItems: MutableList<String> = mutableListOf(
        "Создать архив",
        "Выход"
    )

    override val header = "Список архивов:"

    override fun runActions(response: String): Boolean {
        return when (response.toInt()) {
            menuItems.firstIndex -> { createArchive(); false }
            menuItems.lastIndex -> { exit(); false }
            else -> {
                App.currentArchive = archives[response.toInt() - 1]
                App.currentArchive!!.execute()
                false
            }
        }
    }

    private fun createArchive() {
        CreateArchiveMenu.execute()
    }

    override fun exit() {
        println("Приложение 'Заметки' завершило свою работу.")
    }

    fun addArchive(archive: Archive) {
        archives.add(archive)
        menuItems.add(archives.size, archive.name)
    }
}







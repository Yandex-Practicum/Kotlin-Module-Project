data class Archive(val title: String) : NavigatorSource {
    private val notes = mutableListOf<Note>()
    override fun getMenu(): List<MenuItem> {
        val menu = mutableListOf<MenuItem>()
        menu.add(MenuItem("Создать заметку") { onCreate(it) })
        for (note in notes)
            menu.add(MenuItem(note.title) { onSelect(it) })
        return menu
    }

    private fun onCreate(menuItem: MenuItem) {
        val noteTitle = inputString("Введите заголовок заметки")
        val noteContent = inputString("Введите содержимое заметки заметки")
        notes.add(Note(noteTitle, noteContent))
    }

    private fun onSelect(menuItem: MenuItem) {
        val dataSource = object : NavigatorSource {
            override fun getMenu(): List<MenuItem> {
                val menu = mutableListOf<MenuItem>()
                menu.add(MenuItem("Просмотреть заметку ${menuItem.name}") { showNote(menuItem.name) })
                return menu
            }

            fun showNote(noteTitle: String) {
                val note = notes.find { it.title == noteTitle }
                if (note != null) {
                    println("Название заметки: ${note.title}")
                    println("Содержимое заметки: ${note.content}")
                } else
                    println("Ошибка поиска заметки $noteTitle")
            }
        }
        Navigator().showMenu(dataSource)
    }
}
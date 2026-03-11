class NoteListScreen(
    private val archive: Archive
) {
    fun start() {
        while (true) {
            var exitRequested = false
            val menuItems = mutableListOf<MenuScreen.MenuItem>()

            menuItems.add(MenuScreen.MenuItem("Создать заметку") {
                createNote()
            })

            archive.notes.forEachIndexed { index, note ->
                menuItems.add(MenuScreen.MenuItem(note.title) {
                    NoteViewScreen(note).show()
                })

            }


            menuItems.add(MenuScreen.MenuItem("Назад") {
                exitRequested = true
            })

            val screen = MenuScreen(
                title = "Архив: ${archive.name}\nЗаметки:",
                items = menuItems
            )

            screen.show()
            if (exitRequested) {
                return   // выход из функции start() и возврат в меню архивов
            }
        }
    }

    private fun createNote() {
        println("\nВведите заголовок заметки:")
        val title = readNotEmptyString("Заголовок не может быть пустым")

        println("Введите текст заметки:")
        val text = readNotEmptyString("Текст заметки не может быть пустым")

        archive.notes.add(Note(title, text))
        println("Заметка «$title» сохранена.")
    }
}
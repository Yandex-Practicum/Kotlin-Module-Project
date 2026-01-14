package screens

import menu.Menu
import menu.MenuItem
import model.Archive

class NoteListScreen(private val archive: Archive) {

    fun show() {
        var isBack = false

        while (!isBack) {
            val items = mutableListOf<MenuItem>()

            items.add(MenuItem("Создать заметку") {
                CreateNoteScreen(archive).show()
            })

            for (note in archive.notes) {
                items.add(MenuItem(note.title) {
                    NoteViewScreen(note).show()
                })
            }

            items.add(MenuItem("Назад") {
                isBack = true
            })

            Menu("Архив: ${archive.name}", items).show()
        }
    }
}

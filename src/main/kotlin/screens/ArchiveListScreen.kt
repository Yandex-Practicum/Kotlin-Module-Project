package screens

import menu.Menu
import menu.MenuItem
import storage.Storage

class ArchiveListScreen {

    fun show() {
        var isExit = false

        while (!isExit) {
            val items = mutableListOf<MenuItem>()

            items.add(MenuItem("Создать архив") {
                CreateArchiveScreen().show()
            })

            for (archive in Storage.archives) {
                items.add(MenuItem(archive.name) {
                    NoteListScreen(archive).show()
                })
            }

            items.add(MenuItem("Выход") {
                isExit = true
            })

            Menu("Список архивов:", items).show()
        }
    }
}

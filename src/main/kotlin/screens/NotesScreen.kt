package screens

import ConsoleUtils
import base_screens.ItemsScreen
import data.Archive
import data.Note

class NotesScreen : ItemsScreen<Archive, Note>() {
    init {
        selectItemScreen = SelectNoteScreen()
        createItemScreen = CreateNoteScreen()
    }

    override fun showMenu() {
        ConsoleUtils.showMenu("0-выход 1-создать заметку 2-открыть заметку")
    }
}
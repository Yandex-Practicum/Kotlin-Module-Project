package screens

import ConsoleUtils
import base_screens.SelectItemScreen
import data.Archive
import data.Note

class SelectNoteScreen : SelectItemScreen<Archive, Note>() {
    override fun showMenu() {
        ConsoleUtils.showMenu("0-выход \'Имя заметки\'-открытие заметки с именем")
    }

    override fun select(text: String) {
        if (text.isEmpty()) {
            ConsoleUtils.write("Имя выбранной заметки не должно быть пустым")
            return
        }
        currentItem = item!!.content.firstOrNull { it.name == text }
        if (currentItem == null) {
            ConsoleUtils.write("Такой заметки не существует")
            return
        }
        currentItem!!.showContent()
        return
    }
}
package screens

import ConsoleUtils
import base_screens.CreateItemScreen
import data.Archive
import data.Note

class CreateNoteScreen : CreateItemScreen<Archive, Note>() {
    override fun showMenu() {
        ConsoleUtils.showMenu("0-выход \'Имя заметки\'-создание заметки с именем")
    }

    override fun createContent(text: String) {
        val note = Note(text)
        ConsoleUtils.write("Введите текст заметки")
        val textContent = ConsoleUtils.read()
        note.content.add(textContent)
        item!!.content.add(note)
        ConsoleUtils.write("Заметка с именем $text создана")
    }
}
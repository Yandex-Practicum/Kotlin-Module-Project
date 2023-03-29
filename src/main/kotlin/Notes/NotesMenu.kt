package Notes

import Menu.Menu
import java.util.*

class NotesMenu: Menu() {
    override val menuName: String
        get() = "ЗАМЕТКИ"

    fun addNote(notesMenu: MutableList<Notes>) {
        println("Введите название заметки")
        val noteName = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
        notesMenu.add(notesMenu.size - 1, Notes(noteName, noteText))
        println("Заметка создана")
    }

    fun interactWithNotesMenu(notesMenu: MutableList<Notes>) {
        if (notesMenu.size == 0) {
            notesMenu.add(Notes("Создать заметку", ""))
            notesMenu.add(Notes("Выход", ""))
        }
        while (true) {
            showMenu(notesMenu)
            val amountElements = notesMenu.size - 1
            val menuItem = handleExceptions(amountElements)
            when (menuItem) {
                0 -> addNote(notesMenu)
                notesMenu.size - 1 -> return
                else -> println(notesMenu.get(menuItem).textNote)
            }
        }
    }
}

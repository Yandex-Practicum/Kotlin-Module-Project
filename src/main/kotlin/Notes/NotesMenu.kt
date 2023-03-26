package Notes

import java.util.*

class NotesMenu {
    fun addNote(notesMenu: MutableList<Notes>) {
        println("Введите название заметки")
        val noteName = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
        notesMenu.add(notesMenu.size - 1, Notes(noteName, noteText))
        println("Заметка создана")
    }
    fun showNotesMenu(notesMenu: MutableList<Notes>)  {
        println("ЗАМЕТКИ")
        for(i in 0..notesMenu.size - 1) {
            println("$i. ${notesMenu.get(i).name}")
        }
    }
    fun interactWithNotesMenu(notesMenu: MutableList<Notes>) {
        if (notesMenu.size == 0) {
            notesMenu.add(Notes("Создать заметку", ""))
            notesMenu.add(Notes("Выход", ""))
        }
        while (true) {
            try {
                showNotesMenu(notesMenu)
                val userInputMenuItem = Scanner(System.`in`).nextInt()
                if (userInputMenuItem > notesMenu.size - 1) {
                    println("Введите число в рамках предложенных вариантов")
                    continue
                }
                when (userInputMenuItem) {
                    0 -> addNote(notesMenu)
                    notesMenu.size - 1 -> return
                    else -> println(notesMenu.get(userInputMenuItem).textNote)
                }
            } catch (e: java.util.InputMismatchException) {
                println("Введите число в рамках предложенных вариантов")
            }
        }
    }
}
package Archive

import Notes.Notes
import Notes.NotesMenu
import java.util.*

class ArchivesMenu {
    val archiveMenu: MutableList<Archive> = mutableListOf(
        Archive("Создать архив", mutableListOf()),
        Archive("Выход", mutableListOf())
    )
    val notesMenu = NotesMenu()

    fun addArchive() {
        println("Введите название архива")
        val userInput = Scanner(System.`in`).nextLine()
        archiveMenu.add(archiveMenu.size - 1, Archive(userInput, mutableListOf()))
    }
    fun showArchiveMenu() {
        println("АРХИВЫ")
        for(i in 0..archiveMenu.size - 1) {
            println("$i. ${archiveMenu.get(i).name}")
        }
    }
    fun interactWithArchiveMenu(): MutableList<Notes> {
        while (true) {
            showArchiveMenu()
            val userInputMenuItem = Scanner(System.`in`).nextInt()
            when (userInputMenuItem) {
                0 -> addArchive()
                archiveMenu.size - 1 -> System.exit(0)
                else -> notesMenu.interactWithNotesMenu(archiveMenu.get(userInputMenuItem).notesList)

            }
        }
    }
}
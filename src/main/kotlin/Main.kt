import java.util.*
import kotlin.collections.HashMap

fun main() {
    val archiveMenu = ArchiveMenu()
    val list: MutableList<Notes> = archiveMenu.interactWithArchiveMenu()
    val notesMenu = NotesMenu()
    notesMenu.interactWithNotesMenu(list)
}


open class ArchiveMenu {
    val archiveMenu: MutableList<Archive> = mutableListOf(
        Archive("Создать архив", mutableListOf()),
        Archive("Выход", mutableListOf())
    )
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
                archiveMenu.size - 1 -> goOutArchive()
                else -> return archiveMenu.get(userInputMenuItem).notesList
            }
        }
    }
    fun goOutArchive() {
        System.exit(0)
    }
    fun comeback(bill: Int) {
        interactWithArchiveMenu()
    }
}
class NotesMenu: ArchiveMenu() {
    fun addNote(notes: MutableList<Notes>) {
        println("Введите название заметки")
        val noteName = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteText = Scanner(System.`in`).nextLine()
        notes.add(notes.size - 1, Notes(noteName, noteText))
        println("Заметка создана")
        showNotesMenu(notes)
    }
    fun showNotesMenu(notes: MutableList<Notes>) {
        println("ЗАМЕТКИ")
        for(i in 0..notes.size - 1) {
            println("$i. ${notes.get(i).name}")
        }
    }
    fun interactWithNotesMenu(notes: MutableList<Notes>) { //: Int {
        val notes: MutableList<Notes> = mutableListOf(
            Notes("Создать заметку", ""),
            Notes("Выход", "")
        )
        while (true) {
            showNotesMenu(notes)
            val userInputMenuItem = Scanner(System.`in`).nextInt()
            when (userInputMenuItem) {
                0 -> addNote(notes)
                notes.size - 1 -> interactWithArchiveMenu()//userInputMenuItem
                else -> println(notes.get(userInputMenuItem).textNote)

            }
        }
    }
}

class Archive(
    val name: String,
    var notesList: MutableList<Notes>
)

class Notes(
    val name: String,
    val textNote: String
)

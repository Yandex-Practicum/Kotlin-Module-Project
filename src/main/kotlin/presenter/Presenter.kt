package presenter

import model.Archive
import model.Note


private const val NOTHING = "ничего нет"

object Presenter {
    private val arch1 = Archive("путешествия").apply {
        notes.add(Note("Бали","На бали можно серфить и там жарко"))
        notes.add(Note("Москва","в Москве холодно"))
    }
    private val arch2 = Archive("программирование").apply {
        notes.add(Note("Котлин", "Котлин классный"))
        notes.add(Note("Ковариантность","Это мрак"))
    }

    private val archives = mutableListOf(
        arch1,
        arch2
    )

    fun showAllArchives() {
        if (archives.size > 0) {
            archives.forEachIndexed { index, archive ->
                println("${index + 1} - ${archive.name}")
            }
        } else {
            println(NOTHING)
        }
    }

    fun showNotes(archive: Archive) {
        if (archive.notes.isEmpty()) {
            println(NOTHING)
        } else {
            archive.notes.forEachIndexed { index, note ->
                println("${index + 1} - ${note.title}")
            }
        }
    }

    fun addNewArchive(name: String) {
        archives.add(Archive(name))
        println("архив $name создан")
    }

    fun chooseArchive(num: Int): Archive {
        return archives[num - 1]
    }

    fun addNote(archive: Archive, title: String, text: String) {
        archive.notes.add(Note(title, text))
        println("заметка $title создана")
    }

    fun showNote(note: Note){
        println()
        println(note.text)
        println("____________________")
        println()
    }
}
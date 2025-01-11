import java.util.Scanner

class Note(var title: String, var text: String){
    @Override
    override fun toString(): String {
        return title
    }
}

object NoteManager {
    private val scanner = Scanner(System.`in`)

    fun showNotes(archive: Archive) {
        val noteMenu = Menu("Список заметок в '${archive.name}'")
        noteMenu.addCommand("Создать заметку", action = {-> createNote(archive) })
        archive.notes.forEach() {note ->
            noteMenu.addCommand(note.title, action = {-> readNote(note)})
        }
        noteMenu.showMenuScreen()
    }

    private fun createNote(archive: Archive) {
        while (true) {
            print("Введите название: ")
            val title = scanner.nextLine()
            if (title.isEmpty()) {
                println("Введите непустое название")
                continue
            }
            print("Введите текст: ")
            val text = scanner.nextLine()
            if (text.isEmpty()) {
                println("Введите непустое содержание")
                continue
            }
            archive.notes.add(Note(title, text))
            println("Заметка создана!")
            break
        }
        showNotes(archive)
    }

    private fun readNote(note: Note) {
        println("\n${note.text}")
    }
}
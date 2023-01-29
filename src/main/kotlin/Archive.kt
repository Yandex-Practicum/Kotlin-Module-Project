import java.util.*

class Archive(val name: String): Menu<Note> (mutableMapOf(), mutableMapOf()) {
    val navigator = Navigation<Note?>()
    fun newNote() {
        println("Введите имя заметки, нажмите Enter и введите содержимое заметки")
        val newNote = Note(Scanner(System.`in`).nextLine(), Scanner(System.`in`).nextLine())
        content.put(newNote.name, newNote)
        menu.put("Открыть заметку ${newNote.name}", {navigator.show(content[newNote.name])})

    }
}



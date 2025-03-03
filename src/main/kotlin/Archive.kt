import java.util.Scanner

class Archive (val name: String) {
    private val menu: Menu = Menu("Список заметок в архиве `$name`:")
    private val notes: MutableList<Note> = mutableListOf()

    init {
        menu.listOfCommands.add("Создать заметку" to {createNote()})
    }


    fun archiveScreenStart() {
        notes.forEach { menu.listOfCommands.add(it.name to {it.noteScreenStart()}) }
        menu.start()
    }

    private fun createNote() {
        val note = Note(getNoteTitle(), getNoteText())
        notes.add(note)
        menu.listOfCommands.add(note.name to {note.noteScreenStart()})
        println("Заметка ${note.name} была добавлена в список заметок\n")
    }

    private fun getNoteTitle(): String {
        while (true) {
            println("Введите название заметки:")
            val title = Scanner(System.`in`).nextLine()
            if (title.isEmpty()) {
                println("Название заметки не может быть пустым")
            } else {
                return title
            }
        }
    }

    private fun getNoteText(): String {
        while (true) {
            println("Введите текст заметки:")
            val text = Scanner(System.`in`).nextLine()
            if (text.isEmpty()) {
                println("Текст заметки не может быть пустым")
            } else {
                return text
            }
        }
    }
}

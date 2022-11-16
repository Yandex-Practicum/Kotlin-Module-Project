import java.util.Scanner

class Archive(
    val name: String
) : AbstractMenu<Note>() {
    init {
        println("Создан новый архив с именем $name")
    }

    private var notes: MutableList<Note> = mutableListOf()
    fun showArchive() {
        println("Архив $name")
        println("0. Создать заметку")
        notes.forEachIndexed { index, Note -> println("${index + 1}. ${Note.name}") }
        println("${notes.size + 1}. Выход")
        logic(getCommand(notes), notes)
    }

    override fun createElement() {
        println("Как назовем новую заметку?")
        val nameNote = Scanner(System.`in`).nextLine()
        println("Введите содержание заметки")
        val contentNote = Scanner(System.`in`).nextLine()
        notes.add(Note(nameNote, contentNote))
        showArchive()
    }

    override fun openElement(t: Note) {
        t.showContent()
        showArchive()
    }


}
import java.util.Scanner

class ArchiveScreen(private val archive: Archive) : Screen<Note>() {
    override val list: MutableList<Note> = archive.notes

    val notesMap = mutableMapOf<String, Note>()
    override fun create() {
        println("Введите название заметки:")
        val noteName = Scanner(System.`in`).nextLine()
        if (notesMap[noteName] == null) {
            println("Введите содержимое заметки:")
            val noteContent = Scanner(System.`in`).nextLine()
            val not = Note(noteName, noteContent)
            notesMap[noteName] = not
            list.add(not)
        } else {
            println("Такая заметка существует.")
        }
    }

    override fun show(param: Note) {
        println("Содержание заметки:")
        println("${param.content}")
        println("")
    }

    override fun printMenu(archives: MutableList<Note>) {
        println("${Input.CREATE.code}. Создать заметку")
        for (i in archives.indices) {
            println("${i + 2}. ${archives[i].name}")
        }
        println("${Input.EXIT.code}. Выход")
        println("Введите число:")
    }
}
import java.util.Scanner

class OpenArchive(private val noteList : MutableList<Notes>, private val parent : ArchiveScreen) : Screen<Notes>("заметку", noteList) {
    override fun add() {
        println("Создание новой заметки.\nВведите название новой заметки или Отмена для отмены.")
        val scanner = Scanner(System.`in`).nextLine()
        if (scanner == "Отмена") {
            println("Создание заметки отменено\n")
            show()
            return
        }
        println("Введите текст заметки")
        val text = Scanner(System.`in`).nextLine()
        noteList.add(Notes(scanner, text))
        println("Заметка создана\n")
        show()
    }

    override fun select(i: Int) {
        println("Открываем заметку ${noteList[i - 1].noteName}")
        val note = OpenNote(noteList[i - 1], this)
        note.show()
    }

    override fun goBack() {
        parent.show()
    }
}
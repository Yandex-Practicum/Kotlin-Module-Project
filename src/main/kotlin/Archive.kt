import java.util.*
class Archive : Navigation<Note>() {
    override var first: String = "Создать заметку"
    private fun addNote() {
        val scanner = Scanner(System.`in`)
        println("Введите текст заметки")
        val note = Note(scanner.nextLine())
        collection.add(note)
    }
    override fun execute() {
        addNote()
        menu()
    }
    fun action() {
        while (true) {
            when (input()) {
                0 -> execute()
                collection.size + 1 -> return
            }
        }
    }
}
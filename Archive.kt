import java.util.*

class Archive : Menu<Note>() {

    override var first: String = "Создать заметку"

    fun addNote() {
        val scanner = Scanner(System.`in`)
        println("Введите текст заметки")
        var note: Note = Note(scanner.nextLine())
        collection.add(note)
    }

    override fun execute() {
        addNote()
        menu()

    }

    fun action() {

        while (true) {
            when (val input: Int = input()) {
                0 -> execute()
                collection.size + 1 -> return

            }

        }
    }


}
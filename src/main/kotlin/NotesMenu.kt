import java.util.Scanner

class NotesMenu(private val archive: Archive) {

    private val scanner = Scanner(System.`in`)

    fun start() {

        var exit = false

        while (!exit) {

            val menu = Menu("Архив: ${archive.name}")

            menu.addItem("Создать заметку") {
                createNote()
            }

            archive.notes.forEach { note ->
                menu.addItem(note.name) {
                    showNote(note)
                }
            }

            menu.addItem("Назад") {
                exit = true
            }

            menu.show()
        }
    }

    private fun createNote() {

        println("Введите название заметки:")
        val name = scanner.nextLine()

        if (name.isBlank()) {
            println("Название заметки не может быть пустым")
            return
        }

        println("Введите текст заметки:")
        val text = scanner.nextLine()

        if (text.isBlank()) {
            println("Текст заметки не может быть пустым")
            return
        }

        archive.notes.add(Note(name, text))
    }

    private fun showNote(note: Note) {

        println("Заметка: ${note.name}")
        println(note.text)

        println("Нажмите Enter чтобы вернуться")
        scanner.nextLine()
    }
}
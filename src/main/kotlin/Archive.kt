import java.util.Scanner

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun showNotesMenu(scanner: Scanner) {
        val utils = Utils()

        while (true) {
            println("Список заметок:")
            println("0. Создать заметку")
            notes.forEachIndexed { index, note -> println("${index + 1}. ${note.name}") }
            println("${notes.size + 1}. Выход")

            val input = scanner.nextLine()

            if(utils.validateInput(input)) {
                val number = input.toIntOrNull()
                if (number == null) {
                    utils.viewDigitError()
                } else {
                    when (number) {
                        0 -> createNote(scanner)
                        in 1..notes.size -> {
                            notes[number - 1].showNote()
                        }
                        notes.size + 1 -> return
                        else -> utils.viewDigitError()
                    }
                }
            }
        }
    }


    private fun createNote(scanner: Scanner) {
        println("Введите название заметки:")
        val noteName = scanner.nextLine()
        println("Введите текст заметки:")
        val noteText = scanner.nextLine()

        notes.add(Note(noteName, noteText))
        println("Заметка создана.")
    }
}
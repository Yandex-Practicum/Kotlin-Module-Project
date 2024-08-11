import java.util.Scanner
class Archive(val nameArchive: String) {

    private val notesList = mutableListOf<Note>()

    fun addNote(note: Note) {
        notesList.add(note)
    }

    fun showNotes() {
        if (notesList.isEmpty()) {
            println("Заметок ещё нет")
        } else {
            println("Выберите номер заметки:")
            for ((index, note) in notesList.withIndex()) {
                println("${index + 1}. ${note.nameNote}")
            }
            println("0. Назад")
            var number = Scanner(System.`in`).nextLine().toIntOrNull()
            while (number == null || number !in 0..notesList.size) {
                println("Введите корректный номер")
                number = Scanner(System.`in`).nextLine().toIntOrNull()
            }

            when (number) {
                in 1..notesList.size -> {
                    val noteText = showNoteText(number)
                    println("Текст заметки: $noteText")
                }
                0 -> return
            }
        }
    }

    private fun showNoteText(number: Int): String {
            return notesList[number - 1].text
    }

}
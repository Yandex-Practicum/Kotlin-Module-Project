import java.util.Scanner

class Notes {
    fun createNoteForArchive(archive: Item) {
        while (true) {
            val noteTitle = getUserInput("Введите название заметки:")
            if (noteTitle.isNotEmpty()) {
                archive.addNote(noteTitle)
                println("Заметка \"$noteTitle\" создана!")
                break
            } else {
                println("Название заметки не может быть пустым")
            }
        }
    }

    fun printNotesList(archive: Item) {
        while (true) {
            val notes = archive.listNotes()
            if (notes.isEmpty()) {
                println("Список пуст. Заметки еще не добавлены")
                return
            } else {
                println("Список заметок:")
                for ((index, note) in notes.withIndex()) {
                    println("${index + 1}. $note")
                }
            }

            val readScanner = getUserInput("Выберите заметку, в которую хотите добавить текст, или 0, чтобы вернуться к списку архивов:")
            if (readScanner == "0") {
                break
            } else {
                val noteIndex = readScanner.toIntOrNull()
                if (noteIndex != null && noteIndex in 1..notes.size) {
                    addTextToTheNoteAt(archive, noteIndex - 1)
                } else {
                    println("Вы ввели неверную команду, попробуйте снова.")
                }
            }
        }
    }

    private fun addTextToTheNoteAt(archive: Item, index: Int) {
        while (true) {
            val noteContent = getUserInput("Введите текст в заметку:")
            if (noteContent.isNotEmpty()) {
                archive.addTextToNoteAt(index, noteContent)
                println("Заметка обновлена!")
                break
            } else {
                println("Текст заметки не может быть пустым")
            }
        }
    }

    private fun getUserInput(prompt: String): String {
        println(prompt)
        return Scanner(System.`in`).nextLine().trim()
    }
}
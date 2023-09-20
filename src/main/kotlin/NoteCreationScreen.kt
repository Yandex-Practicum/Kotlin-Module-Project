import java.util.Scanner

object NoteCreationScreen : Creatable {
    override fun createObject(archive: Archive) {
        val listFromHandler = mutableMapOf<String, (() -> Unit)?>()
        listFromHandler["\nСОЗДАНИЕ ЗАМЕТКИ:"] = null
        listFromHandler["\tВведите название создаваемоЙ заметки:"] = {
            archive.notes.add(
                Note(
                    createNote(archive, isName = true),
                    createNote(archive, isName = false)
                )
            )
        }
        listFromHandler["\tОперация успешно завершена."] = { ArchiveSelectionScreen.menuOutput() }
        InputOutputHandler(listFromHandler).inputOutputOperations(this)
    }

    private fun createNote(
        archive: Archive,
        isName: Boolean
    ): String {
        if (isName) {
            var name = ""
            var nameIsPossible: Boolean
            do {
                nameIsPossible = true
                name = Scanner(System.`in`).nextLine()
                archive.notes.forEach { if (name == it.name) nameIsPossible = false }
                if (!nameIsPossible || name == "") {
                    println("\tНазвание заметки не может быть пустой строкой, названия заметок не могут повторяться!")
                    println("\tПовторите ввод:")
                    continue
                }
                return name
            } while (true)
        } else {
            println("Введите текст заметки. Для завершения ввода нажмите Enter:")
            var text = ""
            do {
                text = Scanner(System.`in`).nextLine()
                if (text == "") {
                    println("Заметка не может не сожержать текста. Введите текст:")
                    continue
                }
                return text
            } while (true)
        }
    }
}
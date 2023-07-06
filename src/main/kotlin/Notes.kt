import java.util.*

data class Note(
    val name: String,
    var description: String
) {
    override fun toString() = name
}

class NoteOperations(
    private val archive: Archive
) {
    private val archiveName = archive.name

    fun displayMenuNotes() {
        println("Архив: $archiveName")
        println("1. Выбрать существующую заметку")
        println("2. Создать новую заметку")
        println("3. Вернуться к выбору архива")
    }

    fun selectedMenuNote() {
        val scanner = Scanner(System.`in`)
        var choise: Int
        while (true) {
            println("Введите ваш выбор: ")
            if (scanner.hasNextInt()) {
                choise = scanner.nextInt()
                when (choise) {
                    1 -> {
                        chooseNote()
                        break
                    }
                    2 -> {
                        createNote()
                        break
                    }
                    else -> println("Вы ввели некорректное значение. Пожалуйста введите цифру ещё раз")
                }
            } else {
                println("Вы ввели некорректное значение. Пожалуйста введите цифру ещё раз")
                scanner.next()
            }
        }
    }

    fun chooseNote() {

        println("Доступные заметки: ")
        val noteList =  archive.archivesList
        noteList.forEachIndexed { index, note ->
            println("${index + 1}. ${note.name}")
        }

        println("0. Вернуться к предыдущему меню")
        print("Введите номер заметки: ")
        val choice = readln().toIntOrNull()
        when {
            choice == 0 -> return
            choice != null && choice <= noteList.size -> {
                println(noteList[choice - 1].description)
            }
            else -> {
                println("Неверный выбор.")
            }
        }
    }

    fun createNote() {
        println("Введите имя новой заметки. Или \"-\" что бы вернуться.")
        val noteName = readln().trim()
        if (noteName.isEmpty()) {
            println("Вы не можете создать заметку без заголовка")
        } else if (noteName.equals("-")) {
            return
        } else {
            println("Заметка создана")
            print("Введите текст заметки: ")
            val noteText = readln().trim()
            val note = Note(noteName, noteText)
            archive.archivesList.add(note)
            return
        }

    }
}
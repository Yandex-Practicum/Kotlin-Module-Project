import java.util.Scanner
import kotlin.system.exitProcess

class Archive(val name: String, val notes: MutableList<Note>) {
    val scanner = Scanner(System.`in`)
    fun createNote(archive: Archive, archiveList: MutableList<Archive>) {
        println("Введите название заметки")
        val name = scanner.nextLine()
        if (name.isNullOrEmpty()) {
            println("Название не может быть пустым")
        } else {
            println("Введи текст заметки")
            val text = scanner.nextLine()
            if (text.isNullOrEmpty()) {
                println("Текст не может быть пустым")
            } else {
                val note = Note(name, text)
                archive.notes.add(note)
                println("Заметка создана")
            }
        }
    }

    fun showNotes(archive: Archive, archiveList: MutableList<Archive>) {
        println("Список заметок:")
        println("0 - Создать заметку")
        for (i in archive.notes.indices) {
            println("${i + 1} - ${archive.notes[i].name}")
        }
        println("${archive.notes.size + 1} - Назад")
        val nextLine = scanner.nextLine()
        if (nextLine.toIntOrNull() == null) {
            println("Введите цифру")
        } else {
            val command = nextLine.toInt()
            val exitCommand = archive.notes.size + 1
            when {
                (command == 0) -> createNote(archive, archiveList)
                (command == exitCommand) -> return
                (command > 0 && command <= archive.notes.size) -> showNote(
                    archive.notes[command - 1],
                    archive,
                    archiveList
                )

                else -> println("Некорректный ввод, попробуйте снова")
            }
        }
    }

    fun showNote(note: Note, archive: Archive, archiveList: MutableList<Archive>) {
        println("Заметка:")
        println("Название: ${note.name}")
        println("Текст: ${note.text}")
        println("")
        println("0 - Изменить заметку")
        println("1 - Удалить заметку")
        println("2 - Назад")
        val nextLine = scanner.nextLine()
        if (nextLine.toIntOrNull() == null) {
            println("Введите цифру")
        } else {
            val command = nextLine.toInt()
            when {
                (command == 0) -> editNote(note, archive, archiveList)
                (command == 1) -> archive.notes.remove(note)
                (command == 2) -> return
                else -> println("Некорректный ввод, попробуйте снова")
            }
        }
    }

    fun editNote(note: Note, archive: Archive, archiveList: MutableList<Archive>) {
        println("Введите новый текст заметки:")
        val text = scanner.nextLine()
        if (text.isNullOrEmpty()) {
            println("Текст не может быть пустым")
        } else {
            note.text = text
            println("Заметка успешно изменена")
        }
    }
}



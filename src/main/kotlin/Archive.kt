import java.util.Scanner
import kotlin.system.exitProcess

class Archive(val name: String, val notes: MutableList <Note>) {
    val menuStart1 = Menu()

    fun showNote(note:Note, archive: Archive, list: MutableList<Archive>) {
            val scanner = Scanner(System.`in`)
            println("Заметка: ${note.name}")
            println("Текст:\n${note.text}")
            println("=============================")
            println("0 - Назад")
            println("1 - Добавить текст")
            while (true) {
                val nextLine = scanner.nextLine()
                if (nextLine.toIntOrNull() == null) {
                    println("Необходимо ввести цифру")
                } else {
                    val command = nextLine.toInt()
                    when (command) {
                        0 -> return
                        1 -> return note.addText(note)
                        // 0 -> archive.showNotes(archive, list)
                        else -> println("Некорректное значение, попробуйте снова")
                    }
                }
            }


    }

    fun createNote(archive: Archive, list: MutableList<Archive>) {
        println("Введите название заметки:")
        val scanner = Scanner(System.`in`)

        while (true) {
            val name = scanner.nextLine()
            if (name.isNullOrEmpty()) {
                println("Необходимо ввести название заметки")
            } else {
                println("Введите текст заметки:")
                val text = scanner.nextLine()
                if (text.isNullOrEmpty()) {
                    println("Неоходимо ввести текст заметки") // Здесь дважды приходится вводить
                // текст, ошибку признаю, пытаюсь исправить
                } else {
                    archive.notes.add(Note(name, text))
                    println("Заметка успешно создана.")
                    return archive.showNotes(archive, list)
                }
            }
        }
    }
    fun showNotes(archive: Archive, archiveList: MutableList<Archive>) {
        val scanner = Scanner(System.`in`)
        while (true) {
            if (archive.notes.isEmpty()) {
                println("В архиве пока нет заметок")
                println("0 - Создать заметку")
                println("1 - Назад")
                val nextLine = scanner.nextLine()
                if (nextLine.toIntOrNull() == null) {
                    println("Необходимо ввести цифру")
                } else {
                    val command = nextLine.toInt()
                    when {
                        (command == 0) -> createNote(archive, archiveList)
                        (command == 1) -> return
                        else ->  println("Некорректное значение, попробуйте снова")
                    }
                }


            } else {
                println("Список заметок:")
                println("0 - Создать заметку")
                for (i in archive.notes.indices) {
                    println("${i + 1} - ${archive.notes[i].name}")
                }
                println("${archive.notes.size + 1} - Назад")
                val nextLine = scanner.nextLine()
                if (nextLine.toIntOrNull() == null) {
                    println("Необходимо ввести цифру")
                } else {
                    val command = nextLine.toInt()
                    when {
                        (command == 0) -> createNote(archive, archiveList)
                        (command == archive.notes.size + 1) ->  return //В этом месте идёт возврат
                        // в это же меню, и только со 2го раза работает корректно,не могу
                        // понять в чём дело
                        (command > 0 && command <= archive.notes.size) -> archive.showNote(archive.notes[command - 1], archive, archiveList)
                        else ->  println("Некорректное значение, попробуйте снова")
                    }

                }
            }

        }
    }
}
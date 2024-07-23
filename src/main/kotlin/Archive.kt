import java.util.Scanner

class Archive(val name: String) {
    override fun toString(): String {
        return name
    }

    val notesList: MutableList<Note> = mutableListOf()

    companion object {
        val archives: MutableList<Archive> = mutableListOf()

        fun archiveMenu() {
            while (true) {
                MenuHelper.showMenu(
                    "Приложение заметки\nМеню архивов",
                    listOf("Создать архив") + archives.map { it.name } + "Выход"
                )
                val choice = MenuHelper.readChoice(archives.size + 1)
                when (choice) {
                    0 -> createArchive()
                    in 1..archives.size -> entryArchive(archives[choice - 1])
                    archives.size + 1 -> {
                        println("Программа завершена. До свидания!")
                        return
                    }
                    else -> println("Ошибка ввода, повторите снова.")
                }
            }
        }

        fun createArchive() {
            while (true) {
                println("Введите имя архива:")
                val name = Scanner(System.`in`).nextLine()
                if (name.isNotBlank()) {
                    archives.add(Archive(name))
                    println("Архив $name создан")
                    return
                } else {
                    println("Имя архива не может быть пустым. Повторите ввод")
                }
            }
        }

        fun entryArchive(archive: Archive) {
            while (true) {
                MenuHelper.showMenu(
                    "Архив: $archive",
                    listOf("Создать заметку") + archive.notesList.map { it.name } + "Назад"
                )
                val choice = MenuHelper.readChoice(archive.notesList.size + 1)
                when (choice) {
                    0 -> createNote(archive)
                    in 1..archive.notesList.size -> entryNote(archive.notesList[choice - 1])
                    archive.notesList.size + 1 -> return
                    else -> println("Ошибка ввода, повторите снова.")
                }
            }
        }

        fun createNote(archive: Archive) {
            while (true) {
                println("Введите имя заметки:")
                val name = Scanner(System.`in`).nextLine()
                if (name.isNotBlank()) {
                    println("Введите содержимое заметки:")
                    val content = Scanner(System.`in`).nextLine()
                    if (content.isNotBlank()) {
                        println("Заметка $name с содержимым \n$content создана успешно")
                        archive.notesList.add(Note(name, content))
                        return
                    } else {
                        println("Содержимое заметки не может быть пустым. Повторите ввод")
                    }
                } else {
                    println("Имя заметки не может быть пустым. Повторите ввод")
                }
            }
        }

        fun entryNote(note: Note) {
            println("Название заметки:\n${note.name}\nСодержимое:\n${note.content}")
        }
    }
}

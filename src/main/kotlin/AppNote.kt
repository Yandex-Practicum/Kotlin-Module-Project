import java.util.Scanner
class AppNote {
    val archives = mutableListOf<Archive>()
    val scanner = Scanner(System.`in`)

    fun start() {
        while(true) {

            val archiveList =  mutableListOf<String>()
            archiveList.add("Создать архив")
            for(archive in archives) {
                archiveList.add(archive.archiveName)
            }
            archiveList.add("Выход")

            val button = Menu("ГЛАВНОЕ МЕНЮ", archiveList).show()

            when {
                button == 0 -> createArchive()
                button == archiveList.size - 1 -> return
                else -> if (button != null) {
                    openArchive(archives[button - 1])
                }
            }
        }
    }

    fun createArchive() {
        print("Введите название архива: ")
        val name = scanner.nextLine()

        if(name.isEmpty()) {
            println("Название не может быть пустым!")
            return
        }

        archives.add(Archive(name))
        println("Архив создан!")
    }

    fun openArchive(archive: Archive) {
        while(true) {
            val noteList = mutableListOf<String>()
                noteList.add("Создать заметку")
                for(note in archive.notes) {noteList.add(note.title)}
                noteList.add("Назад")


            val button = Menu("Архив: ${archive.archiveName}", noteList).show()

            when {
                button == 0 -> createNote(archive)
                button == noteList.size - 1 -> {
                    return
                }
                else -> if (button != null) {
                    showNote(archive.notes[button - 1])
                }
            }
        }
    }

    fun createNote(archive: Archive) {
        print("Введите заголовок заметки: ")
        val title =  scanner.nextLine()

        if(title.isEmpty()) {
            println("Заголовок не может быть пустым!")
            return
        }

        print("Введите текст заметки: ")
        val text = scanner.nextLine()

        if(text.isEmpty()) {
            println("Текст не может быть пустым!")
            return
        }

        archive.notes.add(Note(title, text))
        println("Заметка создана!")
    }

    fun showNote(note: Note) {
        println("")
        println("Заметка -> ${note.title}")
        println(note.text)
        println("")
        print("Нажмите Enter для возврата...")
        scanner.nextLine()
    }
}
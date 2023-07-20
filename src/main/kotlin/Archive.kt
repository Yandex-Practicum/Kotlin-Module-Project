import java.util.Scanner

data class Archive(val name: String, val noteList: ArrayList<Note> = ArrayList())

data class Note(val title: String, val content: String)

class MenuManager(private val scanner: Scanner) {
    private val archiveList = ArrayList<Archive>()

    fun startMenu() {
        while (true) {
            println("\nВыберите действие:")
            println("1. Создать архив")
            println("2. Выбрать архив")
            println("3. Выход")

            when (scanner.nextLine()) {
                "1" -> createArchive()
                "2" -> selectArchive()
                "3" -> return
                else -> println("Некорректный ввод, попробуйте снова.")
            }
        }
    }

    private fun selectArchive() {
        println("\nСписок архивов:")
        println("0. Выход")
        for (i in 0 until archiveList.size) {
            println("${i + 1}. ${archiveList[i].name}")
        }

        val userInput = scanner.nextLine().toIntOrNull()
        if (userInput != null && userInput in 1..archiveList.size) {
            val archive = archiveList[userInput - 1]
            archiveMenu(archive)
        } else if (userInput == 0) {
            return
        } else {
            println("Архива с этим номером не найдено, пожалуйста, попробуйте снова.")
        }
    }

    private fun createArchive() {
        println("\nВведите название нового архива:")
        val archiveName = scanner.nextLine()
        val archive = Archive(archiveName)
        archiveList.add(archive)
        println("Архив '$archiveName' создан.")
        archiveMenu(archive)
    }

    private fun archiveMenu(archive: Archive) {
        while (true) {
            println("\nВыбран архив '${archive.name}'. Что вы хотите сделать?")
            println("1. Создать заметку")
            println("2. Выбрать заметку")
            println("3. Вернуться к списку архивов")
            println("4. Вернуться в главное меню")

            when (scanner.nextLine()) {
                "1" -> createNote(archive)
                "2" -> selectNote(archive)
                "3" -> return
                "4" -> {
                    return
                    startMenu() // переход в главное меню
                }
                else -> println("Некорректный ввод, попробуйте снова.")
            }
        }
    }

    private fun selectNote(archive: Archive) {
        println("\nСписок заметок в архиве '${archive.name}':")
        println("0. Вернуться в меню архива")
        for (i in 0 until archive.noteList.size) {
            println("${i + 1}. ${archive.noteList[i].title}")
        }

        val userInput = scanner.nextLine().toIntOrNull()
        if (userInput != null && userInput in 1..archive.noteList.size) {
            val note = archive.noteList[userInput - 1]
            noteScreen(note)
        } else if (userInput == 0) {
            return
        } else {
            println("Заметки с этим номером не найдено, пожалуйста, попробуйте снова.")
        }
    }

    private fun createNote(archive: Archive) {
        println("\nВведите название новой заметки:")
        val noteTitle = scanner.nextLine()
        println("Введите текст заметки:")
        val noteContent = scanner.nextLine()

        val note = Note(noteTitle, noteContent)
        archive.noteList.add(note)
        println("Заметка '$noteTitle' добавлена в архив '${archive.name}'.")
    }

    private fun noteScreen(note: Note) {
        println("\nЗаголовок: ${note.title}")
        println("Текст: ${note.content}")
    }
}





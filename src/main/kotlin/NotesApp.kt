import java.util.Scanner

class NotesApp {
    private val scanner = Scanner(System.`in`)
    private val menu = Menu(scanner)
    private val archiveManager = ArchiveManager()

    fun start() {
        selectArchiveMenu()
    }

    // Экран 1: выбор архива
    private fun selectArchiveMenu() {
        var exit = false

        while (!exit) {
            menu.clearItems()

            menu.addItem("Создать архив") {
                createArchive()
            }

            archiveManager.archives.forEach { archive ->
                menu.addItem(archive.name) {
                    selectNoteMenu(archive)
                }
            }

            menu.showMenu(
                title = "Список архивов",
                zeroLabel = "Выход"
            ) {
                exit = true
            }
        }

        println("Программа завершена")
    }

    // Экран 2: создание архива
    private fun createArchive() {
        val name = menu.readText("Введите название архива: ")

        if (name.isBlank()) {
            println("Название архива не может быть пустым")
            return
        }

        archiveManager.addArchive(Archive(name))
        println("Архив \"$name\" создан")
    }

    // Экран 3: выбор заметки
    private fun selectNoteMenu(archive: Archive) {
        var back = false

        while (!back) {
            menu.clearItems()

            menu.addItem("Создать заметку") {
                createNote(archive)
            }

            archive.notes.forEach { note ->
                menu.addItem(note.name) {
                    viewNote(note)
                }
            }

            menu.showMenu(
                title = "Заметки архива: ${archive.name}",
                zeroLabel = "Назад"
            ) {
                back = true
            }
        }
    }

    // Экран 4: создание заметки
    private fun createNote(archive: Archive) {
        val name = menu.readText("Введите название заметки: ")

        if (name.isBlank()) {
            println("Название заметки не может быть пустым")
            return
        }

        val text = menu.readText("Введите текст заметки: ")

        if (text.isBlank()) {
            println("Текст заметки не может быть пустым")
            return
        }

        archive.addNote(Note(name, text))
        println("Заметка добавлена")
    }

    // Экран 5: просмотр заметки
    private fun viewNote(note: Note) {
        var back = false

        while (!back) {
            println()
            println("=== Просмотр заметки ===")
            println("Название: ${note.name}")
            println("Текст: ${note.text}")

            menu.clearItems()

            menu.showMenu(
                title = "Меню заметки",
                zeroLabel = "Назад"
            ) {
                back = true
            }
        }
    }
}
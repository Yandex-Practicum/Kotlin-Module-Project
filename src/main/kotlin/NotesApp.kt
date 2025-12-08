import java.util.Scanner

class NotesApp(private val scanner: Scanner) {
    private val archives = mutableListOf<Archive>()

    fun start() {
        showArchivesMenu()
    }

    private fun showArchivesMenu() {
        var shouldShowArchivesMenu = true

        while (shouldShowArchivesMenu) {
            val menuItems = mutableListOf<MenuItem>()

            // Пункт "Создать архив"
            menuItems.add(MenuItem("Создать архив") {
                createArchive()
                // После создания архива просто выходим - меню перезапустится
            })

            // Существующие архивы
            archives.forEach { archive ->
                menuItems.add(MenuItem(archive.name) {
                    showNotesMenu(archive)
                })
            }

            val archivesMenu = Menu(
                title = "Список архивов",
                scanner = scanner,
                items = menuItems,
                exitAction = {
                    println("Выход из программы.")
                    System.exit(0)
                }
            )

            archivesMenu.show()
        }
    }

    private fun createArchive() {
        println("\n=== Создание архива ===")

        while (true) {
            print("Введите название архива: ")
            val name = scanner.nextLine().trim()

            when {
                name.isEmpty() -> println("Название архива не может быть пустым.")
                archives.any { it.name == name } -> println("Архив с таким названием уже существует.")
                else -> {
                    archives.add(Archive(name))
                    println("Архив '$name' успешно создан!")
                    return
                }
            }
        }
    }

    private fun showNotesMenu(archive: Archive) {
        var shouldShowNotesMenu = true

        while (shouldShowNotesMenu) {
            val menuItems = mutableListOf<MenuItem>()

            // Пункт "Создать заметку"
            menuItems.add(MenuItem("Создать заметку") {
                createNote(archive)
                // После создания заметки меню перезапустится автоматически
            })

            // Существующие заметки
            archive.notes.forEach { note ->
                menuItems.add(MenuItem(note.title) {
                    showNoteContent(note)
                    // После просмотра заметки меню перезапустится автоматически
                })
            }

            val notesMenu = Menu(
                title = "Архив: ${archive.name}",
                scanner = scanner,
                items = menuItems,
                exitAction = {
                    // Выходим из цикла while, возвращаемся в меню архивов
                    shouldShowNotesMenu = false
                }
            )

            notesMenu.show()
        }
    }

    private fun createNote(archive: Archive) {
        println("\n=== Создание заметки ===")

        val title = getNonEmptyInput("Введите заголовок заметки: ", "Заголовок не может быть пустым.")
        val content = getNonEmptyInput("Введите текст заметки: ", "Текст заметки не может быть пустым.")

        val note = Note(title, content)
        archive.addNote(note)
        println("Заметка '$title' успешно создана!")
    }

    private fun showNoteContent(note: Note) {
        println("\n${"=".repeat(50)}")
        println("Заголовок: ${note.title}")
        println("Дата создания: ${note.createdAt}")
        println("${"-".repeat(50)}")
        println(note.content)
        println("${"=".repeat(50)}")
        println("\nНажмите Enter для продолжения...")
        scanner.nextLine()
    }

    private fun getNonEmptyInput(prompt: String, errorMessage: String): String {
        while (true) {
            print(prompt)
            val input = scanner.nextLine().trim()
            if (input.isNotEmpty()) {
                return input
            }
            println(errorMessage)
        }
    }
}
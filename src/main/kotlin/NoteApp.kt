class NoteApp {
    // объявляю список архивов
    private val archives = mutableListOf<Archive>()

    fun start() {
        showArchivesMenu()
        println("Выход из программы. До свидания!")
    }

    private fun showArchivesMenu() {
        Menu("Список архивов:") {
            val items = mutableListOf<MenuItem>()

            items.add(MenuItem("Создать архив") {
                val name = readNonEmptyInput("Введите имя нового архива:")
                archives.add(Archive(name))
                println("Архив '$name' успешно создан.")
                true
            })

            for (archive in archives) {
                items.add(MenuItem(archive.name) {
                    showNotesMenu(archive)
                    true
                })
            }

            items.add(MenuItem("Выход") {
                false
            })

            items
        }.show()
    }

    private fun showNotesMenu(archive: Archive) {
        Menu("Список заметок архива '${archive.name}':") {
            val items = mutableListOf<MenuItem>()

            items.add(MenuItem("Создать заметку") {
                val name = readNonEmptyInput("Введите имя заметки:")
                val content = readNonEmptyInput("Введите текст заметки:")
                archive.notes.add(Note(name, content))
                println("Заметка '$name' успешно создана.")
                true
            })

            for (note in archive.notes) {
                items.add(MenuItem(note.name) {
                    showNoteDetail(note)
                    true
                })
            }

            items.add(MenuItem("Выход") {
                false
            })

            items
        }.show()
    }

    private fun showNoteDetail(note: Note) {
        println("\n--- Заметка: ${note.name} ---")
        println(note.content)
        println("-------------------------")

        Menu("Просмотр заметки:") {
            listOf(
                MenuItem("Выход") { false }
            )
        }.show()
    }

    // объявляю функцию проверки ввода
    private fun readNonEmptyInput(prompt: String): String {
        while (true) {
            print("$prompt ")
            val input = readLine()?.trim()
            if (!input.isNullOrEmpty()) {
                return input
            }
            println("Ошибка: поле не может быть пустым. Попробуйте еще раз.")
        }
    }
}
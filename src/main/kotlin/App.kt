class App {
    private val archives = mutableListOf<Archive>()
    private var isRunning = true

    fun start() {
        while (isRunning) {
            showArchiveMenu()

        }
        println("Программа завершена")
    }

    private fun showArchiveMenu() {
        val menu = MenuScreen(
            title = "Архивы",
            items = archives.toList(),
            onItemSelected = { archive -> showNotesMenu(archive) },
            onCreateNew = { createArchive() },
            onExit = { exit() }

        )
        menu.show()
    }

    private fun createArchive() {
        val result = CreateScreen("архив").show()
        when (result) {
            is CreateResult.ArchiveCreated -> {
                archives.add(Archive(result.name))
                println("Архив \"${result.name}\" создан!")
            }

            is CreateResult.Cancelled -> {
                println("Создание архива отменено")
            }

            else -> {}
        }
    }

    private fun showNotesMenu(archive: Archive) {
        var isInNotesMenu = true
        while (isInNotesMenu) {
            val menu = MenuScreen(
                title = "Заметки в архиве \"${archive.name}\"",
                items = archive.notes.toList(),
                onItemSelected = { note -> showNote(note) },
                onCreateNew = { createNote(archive) },
                onExit = { isInNotesMenu = false },

                )
            menu.show()
        }
    }


    private fun createNote(archive: Archive) {
        val result = CreateScreen("заметки").show()

        when (result) {
            is CreateResult.NoteCreated -> {
                archive.notes.add(Note(result.name, result.text))
                println("Заметка \"${result.name}\"создана!")
            }

            is CreateResult.Cancelled -> {
                println("Создание заметки отменено")
            }

            else -> {}
        }
    }

    private fun showNote(note: Note) {
        ContentView(note).show()
    }

    private fun exit() {
        isRunning = false

    }
}
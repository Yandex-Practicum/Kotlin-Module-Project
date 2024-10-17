class UserInterface(private val notesApp: NotesApp) {

    fun start() {
        while (true) {
            println("Список архивов:")
            notesApp.displayArchives()
            println("Введите номер архива для выбора, 0 для создания нового архива или -1 для выхода:")
            if (!handleArchiveInput()) break
        }
    }

    fun selectArchive(archiveIndex: Int) {
        val selectedArchive = notesApp.archives[archiveIndex - 1]
        println("Выбрали архив: ${selectedArchive.name}.")

        while (true) {
            println("Заметки в архиве '${selectedArchive.name}':")
            notesApp.displayNotes(selectedArchive.id)
            println("Введите номер заметки для выбора, 0 для создания новой заметки или -1 для выхода в меню архивов:")
            if (!handleNoteInput(selectedArchive.id)) {
                return
            }
        }
    }

    private fun handleArchiveInput(): Boolean {
        val input = readLine() ?: return true
        val option = input.toIntOrNull()

        return when {
            option == null -> {
                println("Пожалуйста, вводите число.")
                true
            }
            option == -1 -> {
                println("Выход из программы.")
                false
            }
            option == 0 -> {
                notesApp.createArchive()
                true
            }
            option in 1..notesApp.archives.size -> {
                selectArchive(option)
                true
            }
            else -> {
                println("Такого элемента нет. Пожалуйста, попробуйте снова.")
                true
            }
        }
    }

    private fun handleNoteInput(archiveId: Int): Boolean {
        val input = readLine() ?: return true
        val option = input.toIntOrNull()

        return when {
            option == null -> {
                println("Пожалуйста, вводите число.")
                true
            }
            option == -1 -> {
                return false
            }
            option == 0 -> {
                notesApp.createNote(archiveId)
                true
            }
            notesApp.notes[archiveId]?.isNotEmpty() == true && option in 1..notesApp.notes[archiveId]!!.size -> {
                notesApp.viewNote(archiveId, option)
                true
            }
            else -> {
                println("Такого элемента нет. Пожалуйста, попробуйте снова.")
                true
            }
        }
    }
}

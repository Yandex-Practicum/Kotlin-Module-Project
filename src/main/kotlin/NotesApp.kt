class NotesApp {
    private val archives = mutableListOf<Archive>()

    fun start() {
        println("Добро пожаловать в приложение Заметки!")
        ArchiveMenu(archives).show()
        println("\nДо свидания!")
    }
}
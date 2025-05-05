class NoteApp {
    private val archives = mutableListOf<Archive>()

    fun start() {
        val mainMenu = object : Menu<Archive>("Список архивов") {
            override fun getItems() = archives
            override fun createItem() {
                createArchive()
            }

            override fun handleItemSelected(item: Archive) {
                val notesMenu = object : Menu<Note>("Список заметок в архиве '${item.name}'") {
                    override fun getItems() = item.notes
                    override fun createItem() {
                        item.createNote()
                    }
                    override fun handleItemSelected(note: Note) {
                        println("\nЗаметка: ${note.title}")
                        println("Содержание:\n${note.content}")
                        println("\nНажмите Enter чтобы вернуться...")
                        readlnOrNull()
                    }
                }
                notesMenu.show()
            }
        }
        mainMenu.show()
    }

    private fun createArchive() {
        val name = InputHandler.readValidInput("Введите название архива:") { it.isNotEmpty() }
        archives.add(Archive(name))
    }
}
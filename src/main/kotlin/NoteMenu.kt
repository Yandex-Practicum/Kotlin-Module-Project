object NoteMenu {
    fun show(archives: Archive){
        val menu = Menu(archives.name)
        menu.addItem("Новая заметка"){
            createNote(archives, menu)
        }
        archives.notes.forEach { note ->menu.addItem(note.title){
            NoteText.show(note)
        } }
        menu.addItem("Назад") {
            menu.end()
        }
        menu.show()
    }
    private fun createNote(archive: Archive, menu: Menu) {
        println("Введите название ")
        val title = menu.readText()
        println("Введите текст  ")
        val content = menu.readText()
        archive.notes.add(Note(title, content))
        println("Заметка добавлена")
        menu.end()
    }
}
object NoteText {
    fun show(note: Note) {

        val menu = Menu("Конец заметки")
        println(note.title)
        println(note.text)

        menu.addItem("Назад") {
            menu.end()
        }
        menu.show()
    }
}
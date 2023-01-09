class Archive(val name: String): Menu() {
    val notes: MutableList<Note> = mutableListOf()
    override val menuItems: MutableList<String> = mutableListOf(
        "Создать заметку",
        "Выход"
    )
    override val header = "Список заметок архива '$name':"

    override fun exit() {
        ListOfArchivesMenu.execute()
    }

    override fun runActions(response: String): Boolean {
        return when (response.toInt()) {
            menuItems.firstIndex -> {createNote(); false}
            menuItems.lastIndex -> {exit(); false}
            else -> {
                App.currentNote = notes[response.toInt() - 1]
                App.currentNote!!.execute()
                false
            }
        }
    }

    private fun createNote() {
        CreateNoteMenu.execute()
    }

    fun addNote(note: Note) {
        notes.add(note)
        menuItems.add(notes.size, note.name)
    }
}
class Archive(val title: String) : Screen {
    override val commandName: String = title
    val listOfNotes: MutableList<Note> = mutableListOf()

    private val menu = Menu("Список заметока архива: $title", NoteCreator(this), listOfNotes)

    override fun onScreen() {
        menu.run()
    }

    override fun toString(): String {
        return title
    }
}
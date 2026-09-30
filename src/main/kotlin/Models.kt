data class Note(
    val title: String,
    val text: String
)

data class Archive(
    val name: String,
    val notes: MutableList<Note> = mutableListOf()
)

class Note(
    val title: String,
    val content: String
)

class Archive(
    val name: String,
    val notes: MutableList<Note> = mutableListOf()
)
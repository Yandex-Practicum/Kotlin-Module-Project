package notes.model

data class Note(
    val title: String,
    val text: String,
    val id: Int,
    val parentId: Int
)

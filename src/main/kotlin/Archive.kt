data class Archive(
    val name : String,
    val list : MutableList<Note> = mutableListOf()
)
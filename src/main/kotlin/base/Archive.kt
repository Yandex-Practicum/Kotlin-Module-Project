package base

data class Archive(
    override val name: String,
    val listOfNotes: MutableList<Note>
): Text
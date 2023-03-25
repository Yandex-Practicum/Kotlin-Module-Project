data class Archive(
    val name: String,
    val notes: MutableList<Note> = mutableListOf()
) {
    override fun toString() = name
}
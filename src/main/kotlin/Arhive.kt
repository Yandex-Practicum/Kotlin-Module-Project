data class Archive(
    val name: String,
    var arhivsList: MutableList<Note>
) {

    override fun toString() = name
}
class Archive(val name: String) : Printable {
    val notes = mutableListOf<Note>()
    override fun getItem() = name
}
class Note(val text: String, val archive: Archive) : Printable {
    override fun getItem() = text
}
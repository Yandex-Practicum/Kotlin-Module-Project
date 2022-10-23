sealed interface MenuElements {
    class Note(val name: String, private val content: String): MenuElements {
        override fun toString(): String {
            return "$name\n$content"
        }
    }
    class Archive(val name: String, val notes: MutableList<Note>): MenuElements
}
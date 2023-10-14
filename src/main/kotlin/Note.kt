data class Note(override val name: String, var text: String) : File {
    override fun toString(): String {
        return ("$name\n\n$text")
    }
}
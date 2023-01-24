data class Archive(val archName: String, val notesArchive: MutableList<Notes>) {
    override fun toString(): String {
        return archName
    }
}

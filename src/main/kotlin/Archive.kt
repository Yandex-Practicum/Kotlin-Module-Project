data class Archive(val archiveDescription: String, val mapOfNotes: MutableMap<Int, Note>?) {
    override fun toString(): String {
        return "$archiveDescription (заметок: ${mapOfNotes?.values?.size})"
    }
}
data class Archive(override var name: String) : Checkable {
    val listOfNote = mutableListOf<Note>()
}
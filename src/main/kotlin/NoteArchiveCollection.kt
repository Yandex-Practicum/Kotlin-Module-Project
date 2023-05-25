object NoteArchiveCollection {

    val noteArchiveCollection: MutableMap<Int, NoteArchive> = mutableMapOf()

    fun addToCollection (name: String) {
        noteArchiveCollection[noteArchiveCollection.size] = NoteArchive(name)
    }

}
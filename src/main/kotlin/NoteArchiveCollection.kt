object NoteArchiveCollection {

    val noteArchiveCollection: MutableMap<Int, NoteArchive> = mutableMapOf()

    fun addToCollection (name: String) {
        noteArchiveCollection.put(noteArchiveCollection.size, NoteArchive(name))
    }

}
package bl

interface IArchives {
    fun list(): MutableList<Archive>
    fun add(archive: Archive)
    fun addNote(archive: Archive, note: Note)
    fun getArchive(archiveId: Int): Archive
    fun create(title: String): Archive
    fun getNote(archiveId: Int, noteId: Int): Note
}
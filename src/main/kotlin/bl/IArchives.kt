package bl

interface IArchives {
    fun List(): MutableList<Archive>
    fun Add(archive: Archive)
    fun AddNote(archive: Archive, note: Note)
    fun Get(title: String): Archive
    fun Create(title: String): Archive
}
package bl

object ArchiveService: IArchives {
    private val archives: MutableList<Archive> = mutableListOf()
    override fun List(): MutableList<Archive> = archives

    override fun Add(archive: Archive) {
        archives.add(archive)
    }

    override fun AddNote(archive: Archive, note: Note) {
        val archLink = archives.first { it.title === archive.title }
        archLink.notes.add(note)
    }

    override fun Get(title: String): Archive {
        return archives.first { it.title === title }
    }

    override fun Create(title: String): Archive {
        return Archive(title, mutableListOf())
    }
}
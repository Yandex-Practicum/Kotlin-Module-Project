package bl

import ui.console.exceptions.ArchiveNotFountException
import ui.console.exceptions.NodeNotFoundException

object ArchiveService: IArchives {
    private val archives: MutableList<Archive> = mutableListOf()
    override fun list(): MutableList<Archive> = archives

    override fun add(archive: Archive) {
        archives.add(archive)
    }

    override fun addNote(archive: Archive, note: Note) {
        val archLink = archives.first { it.title === archive.title }
        archLink.notes.add(note)
    }

    override fun getArchive(archiveId: Int): Archive {
        try{
            return list()[archiveId]
        }catch(ex: Exception){
            throw ArchiveNotFountException(archiveId)
        }

    }

    override fun create(title: String): Archive {
        return Archive(title, mutableListOf())
    }

    override fun getNote(archiveId: Int, noteId: Int): Note {
        val archive = getArchive(archiveId)
        try{
            return archive.notes[noteId]
        }catch(ex: Exception){
            throw NodeNotFoundException(noteId)
        }
    }
}

class ArchiveManager {
    private val archives = mutableMapOf<String, MutableList<Note>>()

    fun createArchive(name: String): Boolean {
        if (name.isBlank() || name in archives) {
            return false
        }
        archives[name] = mutableListOf()
        return true
    }

    fun getArchiveNames(): List<String> = archives.keys.toList()

    fun addNoteToArchive(archiveName: String, title: String, text: String): Boolean {
        val archive = archives[archiveName]
        if (archive == null || title.isBlank()) {
            return false
        }
        archive.add(Note(title, text))
        return true
    }

    fun getNotes(archiveName: String): List<Note> = archives[archiveName] ?: emptyList()

    fun editNote(archiveName: String, index: Int, newTitle: String?, newText: String?): Boolean {
        val archive = archives[archiveName]
        return if (archive != null && index in archive.indices) {
            val note: Note = archive[index]
            note.title = newTitle ?: note.title
            note.text = newText ?: note.text
            true
        } else {
            false
        }
    }

    fun deleteNote(archiveName: String, index: Int): Boolean {
        val archive = archives[archiveName]
        return if (archive != null && index in archive.indices) {
            archive.removeAt(index)
            true
        } else {
            false
        }
    }
}

data class Note(var title: String, var text: String)
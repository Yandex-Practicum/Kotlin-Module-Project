interface CreateInterface {
    val title: String
    var tempData: String
    val backToMenu: () -> Unit

    fun createFromInput ()
}

interface ViewInterface {
    val title: String
    val mapOfMenu: MutableMap<String, () -> Unit>
    fun prepareToView ()
}

object NoteArchiveCollection {

    val noteArchiveCollection: MutableMap<Int, NoteArchive> = mutableMapOf()

    fun addToCollection (name: String) {
        noteArchiveCollection[noteArchiveCollection.size] = NoteArchive(name)
    }
}

class NoteArchive(
    val name: String,
    val noteArchive: MutableMap<Int, Note> = mutableMapOf()
) {
    fun addToNoteArchive (str: String) {
        noteArchive[(noteArchive.size + 1)] = Note(str)
    }
}

data class Note (
    val textOfNote: String
) {}
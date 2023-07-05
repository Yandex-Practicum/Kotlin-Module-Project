class FunctionsAppNotes {
    val archives = mutableListOf<Archive>()

    fun addArchive(name: String) {
        archives.add(Archive(name, mutableListOf()))
    }

    fun addNoteToArchive(numberArchive: Int, nameNote: String, textNote: String) {
        archives[numberArchive].notes.add(Note(nameNote, textNote))
    }

    fun getArсhives(): List<String> {
        return archives.map { it.nameArchive }
    }

    fun getNote(numberArchive: Int): List<String> {
        return archives[numberArchive].notes.map { it.nameNote }
    }

    fun getTextNote(numberArchive: Int, numberNote: Int): String {
        return archives[numberArchive].notes[numberNote].textNote
    }
}
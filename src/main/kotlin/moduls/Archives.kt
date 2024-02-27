package moduls

class Archives {

    private val archives = mutableListOf<String>()
    private val notes = mutableMapOf<String, MutableList<Pair<String, String>>>()

    fun getArchives(): List<String> {
        return archives.toList()
    }

    fun getNotes(archive: String): List<Pair<String, String>>? {
        return notes[archive]?.toList()
    }

    fun addArchive(name: String) {
        archives.add(name)
        notes[name] = mutableListOf()
    }

    fun addNote(archive: String, name: String, text: String) {
        notes[archive]?.add(Pair(name, text))
    }

}
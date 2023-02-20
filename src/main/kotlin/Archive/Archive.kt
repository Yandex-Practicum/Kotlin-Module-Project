package Archive

import Note

class Archive(val name: String, var mapOfNote: MutableMap<String, Note> = emptyMap<String, Note>() as MutableMap<String, Note>) {
    fun addNote(newNote: Note) {
        mapOfNote[newNote.name] = newNote
    }

    fun choseNote(name: String): Note? = mapOfNote[name] ?: null

    override fun toString(): String {
        var listOfNoteNames: String ="It is hole List of Archives: \n"
        for (key in mapOfNote) listOfNoteNames = listOfNoteNames + " \n " + key
        return listOfNoteNames
        return super.toString()
    }
    fun createArchive () {}

}
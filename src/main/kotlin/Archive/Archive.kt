package Archive

import Note

class Archive(val name: String ="", var mapOfNote: MutableMap<String, Note> = mutableMapOf()) {
    fun addNote(newNote: Note) {
        mapOfNote[newNote.name] = newNote
    }

    fun choseNote(name: String): Note? = mapOfNote[name] ?: null

    override fun toString(): String {
        var listOfNoteNames: String ="It is hole List of Notes: \n"
        mapOfNote.forEach { (key, note) -> listOfNoteNames += "Name: $key; " }
        return listOfNoteNames
    }

}
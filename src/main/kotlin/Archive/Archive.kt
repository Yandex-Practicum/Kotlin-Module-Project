package Archive

import Note

class Archive(val name: String ="", var mapOfNote: MutableMap<String, Note> = mutableMapOf()) {
    fun addNote(newNote: Note) {
        mapOfNote[newNote.name] = newNote
    }


    override fun toString(): String {
        var listOfNoteNames ="It is hole List of Notes: \n"
        mapOfNote.forEach { (key, _) -> listOfNoteNames += "Name: $key; " }
        return listOfNoteNames
    }

}
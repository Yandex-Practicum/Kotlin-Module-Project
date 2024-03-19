package utility

import entity.Group
import entity.Note

class DataBaseHelper {
    private var groups: MutableList<Group> = mutableListOf()
    private var notes: MutableList<Note> = mutableListOf()

    private var idGroup: Int = 0

    fun addGroup(name: String) {
        groups.add(Group(idGroup, name))
        idGroup++
    }

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun getGroup(idGroup: Int): Group {
        return groups[idGroup]
    }

    fun getGroups(): MutableList<Group> {
        return groups
    }

    fun getNotesGroup(idGroup: Int): MutableList<Note> {
        val notesGroup: MutableList<Note> = mutableListOf()
        for (note: Note in notes) {
            if (note.idGroup == idGroup) notesGroup.add(note)
        }
        return notesGroup
    }

    fun getNoteGroup(idNote: Int): Note {
        return notes[idNote]
    }

    fun updateNote(note: Note) {
        notes[note.id] = note
    }

    fun deleteNote(note: Note) {
        notes.remove(note)
    }
}
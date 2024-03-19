package utility

import entity.Group
import entity.Note

class DataBaseHelper {
    private var groups: MutableList<Group> = mutableListOf()
    private var notes: MutableList<Note> = mutableListOf()
    private var maskNotes: MutableMap<Int, Int> = mutableMapOf() // список маски ID заметок key = значение меню, value = ID заметки

    private var idGroup: Int = 0

    fun addMaskNotes(number: Int, id: Int) {
        maskNotes.put(number, id)
    }

    fun maskToIdNote(number: Int): Int {
        return maskNotes.getValue(number)
    }

    fun clearMaskNotes() {
        maskNotes.clear()
    }

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
        var result: Note = notes[0]
        for (note: Note in notes) {
            if (note.id == idNote) {
                result = note
                break
            }
        }
        return result
    }

    fun updateNote(noteInput: Note) {
        var index = 0
        for (note: Note in notes) {
            if (note.id == noteInput.id) {
                index = notes.indexOf(note)
                break
            }
        }
        notes[index] = noteInput
    }

    fun deleteNote(note: Note) {
        notes.remove(note)
    }
}
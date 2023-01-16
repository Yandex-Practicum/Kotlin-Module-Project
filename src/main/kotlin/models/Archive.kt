package models

class Archive(val name: String,val notes: MutableList<Note> = mutableListOf<Note>()) {
    override fun toString() = name
}
package models

class Note(val text: String, val archive: Archive) {
    override fun toString() = text
}
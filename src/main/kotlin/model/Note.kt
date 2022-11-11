package model

data class Note(val id: Int, var name: String, var archiveId: Int, var text: String?) {
    override fun toString() = "Заметка \"$name\""
}
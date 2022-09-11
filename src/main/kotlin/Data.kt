data class Archive(val name: String, val notesList: List<Note> = listOf())

data class Note(val name: String, val text: String) {
    fun printNote() {
        println("Название: $name\nТекст: $text")
    }
}
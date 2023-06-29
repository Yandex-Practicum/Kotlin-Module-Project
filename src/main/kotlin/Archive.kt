data class Note(val title: String, val text: String) {
    fun showNote() {
        println("Заголовок: ${this.title}")
        println("Текст: ${this.text}")
    }
}

class Archive(val name: String) {
    private val notes = mutableListOf<Note>()

    fun addNote() {
        println("Введите название заметки:")
        val title = readlnOrNull() ?: ""
        println("Введите содержимое заметки:")
        val text = readlnOrNull() ?: ""
        notes.add(Note(title, text))
        println("Заметка успешно добавлена.")
    }

    fun getNotes(): List<Note> {
        return notes.toList()
    }
}
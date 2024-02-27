package moduls

class Notes {
    fun NoteDetails(note: Pair<String, String>?) {
        println("Заметка:")
        println("Название: ${note?.first}")
        println("Текст: ${note?.second}")
    }
}
class Note(val title: String, val content: String) {
    init {
        require(title.isNotBlank()) { "Название заметки не может быть пустым." }
    }
    init {
        require(content.isNotBlank()) { "Содержимое заметки не может быть пустым." }
    }
}
class NoteManager {
    val archives = mutableListOf<Archive>()

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }

    fun viewNotesInArchive(archiveIndex: Int) {
        val archive = archives[archiveIndex]
        if (archive.notes.isEmpty()) {
            println("В архиве '${archive.name}' нет заметок.")
        } else {
            println("Заметки в архиве '${archive.name}':")
            archive.notes.forEachIndexed { index, note ->
                println("${index + 1}. ${note.title}")
            }
            print("Введите номер заметки для просмотра (или 0 для выхода): ")
            val input = readLine()
            val noteIndex = input?.toIntOrNull()
            if (noteIndex != null && noteIndex in 1..archive.notes.size) {
                val selectedNote = archive.notes[noteIndex - 1]
                println("Заголовок: ${selectedNote.title}")
                println("Содержимое: ${selectedNote.content}")
            } else if (noteIndex == 0) {
                return
            } else {
                println("Некорректный номер заметки.")
            }
        }
    }
}
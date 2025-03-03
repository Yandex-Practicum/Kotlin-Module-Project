// Класс для хранения данных об архиве
class Archive(val name: String) {
    val notes = mutableListOf<Note>() // Список заметок в архиве
}
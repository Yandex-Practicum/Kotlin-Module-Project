package screens

import data.Database
import model.Note
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CreateNoteScreen(private val archive: String) {

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH:mm")

    init {
        createNote()
    }

    private fun createNote() {
        print("Введите заголовок: ")
        val title = readLine()!!
        print("Введите текст: ")
        val text = readLine()!!
        val date = provideCurrentDate()
        val note = Note(title, text, date)
        Database.addNote(archive, note)
        println("Заметка ${note.title} успешно создана!")
    }

    private fun provideCurrentDate() = LocalDateTime.now().format(formatter)
}
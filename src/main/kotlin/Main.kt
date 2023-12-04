import java.util.*

//хранение заметки
data class Note(val title: String, val content: String)

//хранение архива
class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())
//запуск
fun main() {
    val app = NotesApp()
    app.start()
}

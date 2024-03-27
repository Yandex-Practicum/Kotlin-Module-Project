fun main(args: Array<String>) {
    println("Hello World!")
}
data class Note(val title: String, val content: String)

class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())
fun main() {
    val app = NotesApp()
    app.start()}
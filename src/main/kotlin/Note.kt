class Note(
    val name: String,
    private val text: String
)
{
    fun showNote() {
        println("Название заметки: $name")
        println("Текст в заметке: $text")
        println("")
    }
}

class Note(
    val name: String,
    val text: String
    )
{
    fun showNote() {
        println("Название заметки: $name")
        println("Текст в заметке: $text")
        println("")
    }
}

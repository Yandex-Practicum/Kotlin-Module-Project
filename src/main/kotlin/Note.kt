open class Note(
    val name: String,
    val text: String,
) {
    fun showList() {
        println("Название заметки: $name")
        println("Текст в заметке: $text")
        println("")
    }

}

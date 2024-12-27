class Note(val title: String, private val content: String) {
    fun showContent() {
        println("Заметка: $title")
        println("Содержание: $content")
        println("Нажмите Enter для возврата.")
        readLine()
    }
}

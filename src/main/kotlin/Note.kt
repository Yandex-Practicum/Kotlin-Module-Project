class Note(val title: String, private val content: String) {
    fun show() {
        println("Заголовок: $title")
        println("Содержание: $content")
        println("Нажмите Enter, чтобы вернуться.")
        readLine()
    }
}

class Note(
    val name: String, private val content: String
) : Any() {init {
    println("Создана новая заметка с именем $name")
}

    fun showContent() {
        println("Заметка $name")
        println(content)
    }
}
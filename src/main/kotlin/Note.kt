class Note(
    val name: String, private val content: String
) {init {
    println("Создана новая заметка с именем $name")
}

    fun showContent() {
        println("Заметка $name")
        println(content)
    }
}
class Note (
    val name: String,
    val text: String
) {
    private val menu: Menu = Menu("Текст заметки `$name`:")

    init {
        menu.listOfCommands.add("Показать текст заметки" to {getText()})
    }

    fun noteScreenStart() {
        menu.start()
    }

    private fun getText() {
        println("$text\n")
    }
}
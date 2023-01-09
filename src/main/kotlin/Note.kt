class Note(val name: String, private val content: String): Menu() {

    override val menuItems = listOf(
        "Показать содержимое заметки",
        "Выход"
    )

    override val header = "Меню заметки с именем '$name':"

    override fun runActions(response: String): Boolean {
         return when (response.toInt()) {
             menuItems.firstIndex -> {showContent(); true}
             else -> {exit(); false}
         }
    }

    private fun showContent() {
        println("\n $content \n")
    }

    override fun exit() {
        App.currentArchive?.execute()
    }
}
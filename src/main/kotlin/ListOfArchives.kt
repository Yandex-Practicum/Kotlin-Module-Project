/**
 * Содержит список архивов
 */
class ListOfArchives : Screen {
    private val title = "Список архивов"
    override val commandName: String = title
    val listOfArchives = mutableListOf<Archive>()

    private val menu = Menu("$title:", ArchiveCreator(this), listOfArchives)

    override fun onScreen() {
        menu.run()
    }
}
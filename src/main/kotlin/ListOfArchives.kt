/**
 * Содержит список архивов
 */
class ListOfArchives private constructor() : Screen {
    private val title = "Список архивов"
    override val commandName: String = title
    val listOfArchives = mutableListOf<Archive>()

    private val menu = Menu("$title:", ArchiveCreator(this), listOfArchives)

    override fun onScreen() {
        menu.run()
    }

    companion object {
        fun run() = ScreenStack.push(ListOfArchives())
    }
}
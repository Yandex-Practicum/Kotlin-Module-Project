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
        private var isCreated = false

        fun run() {
            if(isCreated) return
            isCreated = true
            ScreenStack.push(ListOfArchives())
        }
    }
}
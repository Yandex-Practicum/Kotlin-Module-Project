import utils.ErrMessage.*
import utils.RequestMessage.*
import utils.getStringInput

class ArchiveCreator(private val source: ListOfArchives) : Screen {
    override val commandName: String = "Создать архив"

    override fun onScreen() {
        createArchive()
        ScreenStack.pop()
    }

    private fun createArchive() {
        println("Создазие архива")
        val title = getStringInput(ENTER_TITLE, ERROR_EMPTY)
        source.listOfArchives.add(Archive(title))
    }
}
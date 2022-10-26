import utils.ErrMessage.*
import utils.RequestMessage.*
import utils.getStringInput

class NoteCreator(private val source: Archive) : Screen {
    override val commandName: String = "Создать заметку"

    override fun onScreen() {
        createNote(source)
        ScreenStack.pop()
    }

    private fun createNote(archive: Archive) {
        println("Архив: ${archive.title}")
        println("Создазие заметки")

        val noteTitle = getStringInput(ENTER_TITLE, ERROR_EMPTY)
        val noteContent = getStringInput(ENTER_TEXT, ERROR_EMPTY)

        archive.listOfNotes.add(Note(noteTitle, noteContent))
    }
}
package notes.screens

import core.menu.MenuNode
import core.menu.validation.softMenuValidation
import core.screens.BaseScreen

class CreateNoteScreen(private val archiveId: Int) : BaseScreen() {
    override val title: String ="$TITLE ${repository.resolveArchive(archiveId)?.name}"
    private var noteTitle: String? = null

    override fun start() {
        showMenu()
        println(ASK_FOR_TITLE_TEXT)
        waitForInput {
            onTextInput(it)
        }
    }

    override fun resolveMenu(): List<MenuNode> {
        return listOf(MenuNode.Exit)
    }

    private fun onTextInput(input: String) {
        softMenuValidation(input) {
            noteTitle?.let { title ->
                repository.addNote(title, it, archiveId)
                println(String.format(ARCHIVE_SAVED_TEMPLATE, title))
                exitScreen()
                return@softMenuValidation
            }
            noteTitle = it
            println(ASK_FOR_DESCRIPTION_TEXT)
            waitForInput {
                onTextInput(input)
            }
        }
    }

    companion object {
        const val TITLE = "Создать заметку в архиве"
        const val ASK_FOR_TITLE_TEXT = "Введите заголовок"
        const val ASK_FOR_DESCRIPTION_TEXT = "Введите текст заметки"
        const val ARCHIVE_SAVED_TEMPLATE = "Заметка %s создана"
    }
}

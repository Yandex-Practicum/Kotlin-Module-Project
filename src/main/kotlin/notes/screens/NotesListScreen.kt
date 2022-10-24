package notes.screens

import core.menu.MenuNode
import core.menu.createPickerMenu
import core.screens.BaseScreen
import core.menu.validation.strictMenuValidation
import navigation.Screens
import notes.mapper.mapToMenuItems

class NotesListScreen(private val archiveId: Int) : BaseScreen() {
    override val title: String = "$TITLE ${repository.resolveArchive(archiveId)?.name}"
    override fun start() {
        showMenu()
        waitForInput {
            strictMenuValidation(it)
        }
    }

    override fun resolveMenu(): List<MenuNode> {
        return createPickerMenu(
            MenuNode.Create(CREATE_MENU_TITLE, Screens.CreateNote(archiveId)),
            repository.getAllNotes(archiveId).mapToMenuItems()
        )
    }

    companion object {
        const val TITLE = "Список заметок архиве"
        const val CREATE_MENU_TITLE = "Создать заметку"
    }
}

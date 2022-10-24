package archives.screens

import archives.mapper.mapToMenuItems
import core.menu.MenuNode
import core.menu.createPickerMenu
import core.screens.BaseScreen
import core.menu.validation.strictMenuValidation
import navigation.Screens

class ArchivesScreen : BaseScreen() {
    override val title: String = TITLE
    override fun start() {
        showMenu()
        waitForInput {
            strictMenuValidation(it)
        }
    }

    override fun resolveMenu(): List<MenuNode> {
        return createPickerMenu(
            MenuNode.Create(CREATE_MENU_TITLE, Screens.CreateArchive),
            repository.getAllArchives().mapToMenuItems()
        )
    }

    companion object {
        const val TITLE = "Список архивов"
        const val CREATE_MENU_TITLE = "Создать Архив"
    }
}

package archives.screens

import core.menu.MenuNode
import core.screens.BaseScreen
import core.menu.validation.softMenuValidation

class CreateArchiveScreen : BaseScreen() {

    override val title: String = TITLE

    override fun start() {
        showMenu()
        println(ASK_FOR_ARCHIVE_NAME_TEXT)
        waitForInput {
            softMenuValidation(it) { validated ->
                onTextInput(validated)
            }
        }
    }

    override fun resolveMenu(): List<MenuNode> {
        return listOf(MenuNode.Exit)
    }

    private fun onTextInput(input: String) {
        repository.addArchive(input)
        println(String.format(ARCHIVE_SAVED_TEMPLATE, input))
        exitScreen()
    }

    companion object{
        const val TITLE = "Создание Архива"
        const val ASK_FOR_ARCHIVE_NAME_TEXT = "Введите имя архива"
        const val ARCHIVE_SAVED_TEMPLATE = "Архив с именем %s создан"
    }
}

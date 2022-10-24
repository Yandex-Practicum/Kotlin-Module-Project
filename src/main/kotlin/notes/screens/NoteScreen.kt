package notes.screens

import core.menu.MenuNode
import core.screens.BaseScreen
import core.menu.validation.strictMenuValidation

class NoteScreen(id: Int): BaseScreen() {
    private val info = repository.resolveNote(id)
    override val title: String = info?.title ?: NOTE_NOT_FOUND_PLACEHOLDER

    override fun start() {
        showMenu()
        info?.text?.let { println(it) }
        waitForInput{
            strictMenuValidation(it)
        }
    }

    override fun resolveMenu(): List<MenuNode> {
       return listOf(MenuNode.Exit)
    }

    companion object{
        const val NOTE_NOT_FOUND_PLACEHOLDER = "Джон Доу"
    }
}

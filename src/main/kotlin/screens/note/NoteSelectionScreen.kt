package screens.note

import MenuLogic
import entities.Archive
import entities.MenuItem
import screenLogic.EntityScreenLogic
import screens.interfaces.EntityScreen

object NoteSelectionScreen: EntityScreen {

    override val menu = mutableListOf<MenuItem>()
    override val menuLogic = MenuLogic(menu)
    override val entityScreenLogic = EntityScreenLogic(this)

    fun show(archive: Archive, archives: MutableList<Archive>) {
        print("Список заметок: ")
        entityScreenLogic.createMenu(archive, archives)
    }
}
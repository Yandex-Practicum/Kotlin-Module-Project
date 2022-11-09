package screens.archive

import MenuLogic
import entities.Archive
import entities.MenuItem
import screenLogic.EntityScreenLogic
import screens.BaseScreen
import screens.interfaces.EntityScreen

object ArchiveSelectionScreen: EntityScreen {


    override val menu = mutableListOf<MenuItem>()
    override val menuLogic = MenuLogic(menu)

    override val entityScreenLogic = EntityScreenLogic(this)

    fun show(archives: MutableList<Archive>) {
        if (archives.size == 0) {
            println("Список архивов пустой, добавьте архив")
            BaseScreen.start()
        }
        entityScreenLogic.createMenu(null, archives)
    }
}
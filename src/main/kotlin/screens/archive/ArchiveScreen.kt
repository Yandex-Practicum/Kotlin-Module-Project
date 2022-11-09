package screens.archive

import MenuLogic
import entities.Archive
import entities.MenuItem
import screenLogic.EntityScreenLogic
import screens.interfaces.EntityScreen
import screens.note.NoteSelectionScreen

object ArchiveScreen: EntityScreen {

    override val menu = mutableListOf<MenuItem>()
    override val menuLogic = MenuLogic(menu)
    override val entityScreenLogic = EntityScreenLogic(this)

    fun show(archive: Archive, archives: MutableList<Archive>) {
        println("Архив - ${archive.name}")
        if (archive.notes.size == 0) {
            println("Список заметок в архиве ${archive.name} пустой, добавьте заметку")
        } else {
            NoteSelectionScreen.show(archive, archives)
        }
        entityScreenLogic.createMenu(archive, archives)
    }

}
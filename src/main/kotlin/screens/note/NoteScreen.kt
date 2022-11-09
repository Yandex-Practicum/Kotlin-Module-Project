package screens.note

import MenuLogic
import entities.Archive
import entities.MenuItem
import entities.Note
import screenLogic.EntityScreenLogic
import screens.interfaces.EntityScreen

object NoteScreen: EntityScreen {

    override val menu = mutableListOf<MenuItem>()
    override val menuLogic = MenuLogic(menu)
    override val entityScreenLogic = EntityScreenLogic(this)

    fun show(note: Note, noteArchive: Archive, archives: MutableList<Archive>) {
        println("Имя заметки - ${note.name} \n" +
                "Текст заметки - ${note.text}")

        entityScreenLogic.createMenu(noteArchive, archives)
    }
}
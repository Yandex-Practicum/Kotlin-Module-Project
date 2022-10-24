package archives.mapper

import archives.model.Archive
import core.menu.MenuNode
import navigation.Screens

fun List<Archive>.mapToMenuItems(): List<MenuNode>{
    return this.map {
       MenuNode.Pick(name = it.name, Screens.NotesList(it.id))
    }
}

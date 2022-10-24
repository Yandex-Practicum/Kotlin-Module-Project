package notes.mapper

import core.menu.MenuNode
import navigation.Screens
import notes.model.Note

fun List<Note>.mapToMenuItems(): List<MenuNode>{
    return this.map {
       MenuNode.Pick(name = it.title, Screens.Note(it.id))
    }
}

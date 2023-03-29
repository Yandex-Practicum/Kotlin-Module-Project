package Archive

import Menu.MenuItem
import Notes.Notes
import Notes.NotesMenu

class Archive(
    val name: String,
    val notesList: MutableList<Notes>
): MenuItem {
    override val menuItem: String
        get() = name
}
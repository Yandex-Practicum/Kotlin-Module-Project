package Menu

import BaseCreator
import Item.Note

class NoteMenu (
    override val items: MutableList<Note>,
    override val greeting: String,
    override val createActionName: String
): BaseMenu<Note>(items, greeting, createActionName) {
    override fun createItem(): Note {
        return BaseCreator().createNote()
    }

    override fun actionForSelectedItem(item: Note) {
        println("\n" + item.name)
        println(item.content + "\n")
    }
}
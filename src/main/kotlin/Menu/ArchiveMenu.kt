package Menu

import BaseCreator
import Item.Archive

class ArchiveMenu (
    override val items: MutableList<Archive>,
    override val greeting: String,
    override val createActionName: String
): BaseMenu<Archive>(items, greeting, createActionName) {
    override fun createItem(): Archive {
       return BaseCreator().createArchive()
    }

    override fun actionForSelectedItem(item: Archive) {
        NoteMenu(
            item.notes,
            "Список заметок",
            "Создать заметку"
        ).start()
    }
}

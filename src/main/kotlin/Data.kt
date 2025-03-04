abstract class ManageableItem {
    abstract val title: String
}

data class NoteItem(override val title: String, val content: String) : ManageableItem()
data class ArchiveItem(override val title: String, val notes: MutableList<NoteItem> = mutableListOf()) : ManageableItem()


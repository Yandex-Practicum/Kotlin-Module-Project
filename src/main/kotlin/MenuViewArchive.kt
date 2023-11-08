class MenuArchive (val key: Int) : ViewInterface {
    override val title = "меню просмотра архива"
    override val mapMenu: MutableMap<String, () -> Unit> = mutableMapOf()

    override fun prepareToView () {
        val tempNoteArchive: NoteArchive? = NoteArchiveCollection.noteArchiveCollection[key]

        mapMenu["Создать заметку"] = {menu.showCreateMenu(MenuCreate(key))}
        for (key in tempNoteArchive?.noteArchive!!.keys) {
            mapMenu[tempNoteArchive.noteArchive[key]!!.textOfNote] = {menu.showCreateMenu(MenuViewNote(this.key,
                tempNoteArchive.noteArchive[key]!!.textOfNote))}
        }
        mapMenu["Выход"] = {menu.showViewMenu(MenuArchiveCollection())}
    }
}
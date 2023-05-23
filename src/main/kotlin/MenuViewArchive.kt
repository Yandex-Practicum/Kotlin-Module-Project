class MenuViewArchive (val key: Int) : ViewInterface {
    override val title = "меню просмотра архива"
    override val mapOfMenu: MutableMap<String, () -> Unit> = mutableMapOf()

    override fun prepareToView () {
        val tempNoteArchive: NoteArchive? = NoteArchiveCollection.noteArchiveCollection[key]

        mapOfMenu.put("Создать заметку") {menu.showCreateMenu(MenuCreateNote(key))}
        for (key in tempNoteArchive?.noteArchive!!.keys) {
            mapOfMenu.put(tempNoteArchive.noteArchive[key]!!.textOfNote) {menu.showCreateMenu(MenuViewNote(this.key,
                                                                            tempNoteArchive.noteArchive[key]!!.textOfNote))}
        }
        mapOfMenu.put("Выход") {menu.showViewMenu(MenuArchiveCollection())}
    }
}
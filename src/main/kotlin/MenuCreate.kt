class MenuCreate (val key: Int) : CreateInterface {
    override val title = "Введите текст заметки"
    override var nameArchive = ""
    override val backMenu: () -> Unit = {menu.showViewMenu(MenuArchive(key))}

    override fun createFromInput() {
        println(title)
        nameArchive = menu.getUserInput()
        NoteArchiveCollection.noteArchiveCollection[key]!!.addToNoteArchive(nameArchive)
        println("Создана заметка: ")
        println(nameArchive)
        backMenu.invoke()
    }
}
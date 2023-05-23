class MenuCreateNote (val key: Int) : CreateInterface {
    override val title = "Введите заметку или 0 для выхода"
    override var tempData = ""
    override val backToMenu: () -> Unit = {menu.showViewMenu(MenuViewArchive(key))}

    override fun createFromInput() {
        println(title)
        tempData = menu.getUserInput()
        NoteArchiveCollection.noteArchiveCollection[key]!!.addToNoteArchive(tempData)
        println("Создана заметка: ")
        println(tempData)
        backToMenu.invoke()
    }
}
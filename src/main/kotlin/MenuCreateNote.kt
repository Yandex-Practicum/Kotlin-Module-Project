class MenuCreateNote (val key: Int) : CreateInterface {
    override val title = "Введите текст заметки"
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
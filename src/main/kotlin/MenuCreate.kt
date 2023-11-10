class MenuCreate (val key: Int) : CreateInterface {
    override val title = "Введите текст заметки"
    override var nameArchive = ""
    override val backMenu: () -> Unit = {menu.showViewMenu(MenuArchive(key))}

    override fun createFromInput() {
        println(title)
        nameArchive = menu.getUserInput()
        if (nameArchive.isEmpty()) {
            println("Заметка не может быть пустой")
            backMenu.invoke() }
        NoteArchiveCollection.noteArchiveCollection[key]!!.addToNoteArchive(nameArchive)
        println("Создана заметка: $nameArchive")
        backMenu.invoke()
    }
}
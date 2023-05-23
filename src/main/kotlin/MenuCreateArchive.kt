class MenuCreateArchive () : CreateInterface {
    override val title = "Введите имя архива или 0 для выхода"
    override var tempData = ""
    override val backToMenu = {menu.showViewMenu(MenuArchiveCollection())}

    override fun createFromInput() {
        println(title)
        tempData = menu.getUserInput()
        NoteArchiveCollection.addToCollection(tempData)
        println("Создан архив с именем: $tempData")
        backToMenu.invoke()
    }

}
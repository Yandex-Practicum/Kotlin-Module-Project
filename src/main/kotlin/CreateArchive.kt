class CreateArchive () : CreateInterface {
    override val title = "Введите имя архива"
    override var nameArchive = ""
    override val backMenu = {menu.showViewMenu(MenuArchiveCollection())}

    override fun createFromInput() {
        println(title)
        nameArchive = menu.getUserInput()
        NoteArchiveCollection.addToCollection(nameArchive)
        println("Создан архив с именем: $nameArchive")
        backMenu.invoke()
    }

}
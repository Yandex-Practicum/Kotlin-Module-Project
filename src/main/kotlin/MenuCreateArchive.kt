class MenuCreateArchive () : CreateInterface {
    override val title = "Введите имя архива"
    override var tempData = ""
    override val backToMenu = {menu.showViewMenu(MenuArchiveCollectionView())}

    override fun createFromInput() {
        println(title)
        tempData = menu.getUserInput()
        NoteArchiveCollection.addToCollection(tempData)
        println("Создан архив с именем: $tempData")
        backToMenu.invoke()
    }

}